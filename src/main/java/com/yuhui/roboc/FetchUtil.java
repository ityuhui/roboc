package com.yuhui.roboc;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchUtil {
	
	private final static String BASEURL = "http://xueqiu.com/S/";
	
	private final static double CURRENCE = 20833.04;
	
	private final static HashMap<String, StockItem> mData = new HashMap<String,StockItem>(){

		private static final long serialVersionUID = 6717526200353650787L;

		{
			
			put("SH510050",new StockItem("SH510050",900,1.242));
			//put("SH600104",new StockItem("SH600104",500,25.891));
			//put("SH600248",new StockItem("SH600248",2000,18.371));
			//put("SZ002216",new StockItem("SZ002216",1500,20.263));
			//put("SZ002340",new StockItem("SZ002340",3240,15.257));
			//put("SZ002399",new StockItem("SZ002399",2300,40.027));
			//put("SZ002549",new StockItem("SZ002549",420,7.390));
			
		}
		
	};
	
	public static double printSto(String code){
		double retVal = 0;
		Document doc;
		try {
			String url = BASEURL + code ;
			doc = Jsoup.connect(url).get();
			System.out.println(doc);
			Element name = doc.select(".stockName").first();
			Element cp1 = doc.select("div.currentInfo strong").first();
			String currentPriceStr = cp1.attr("data-current");
			
			Element qp = doc.select(".quote-percentage").first();
			String output = name.text() + " : Current Price:" + currentPriceStr + ":" + qp.text();
			System.out.println(output);
			
			StockItem si = (StockItem)mData.get(code);
			
			double currentPrice = Double.parseDouble(currentPriceStr);
			double cpv =  currentPrice - si.getCost();
			double rate = cpv / si.getCost() * 100.0;
			double value = currentPrice * si.getHold();
			double earn  = cpv * si.getHold() ;
			
			//System.out.printf("Earn Rate: %+.2f%%\n",rate);
			//System.out.printf("Earn Value:  %.2f\n",earn);
			//System.out.printf("ALL Value: %.2f\n",value);
			
			retVal = value;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return retVal;
	}
	
	public static void printStock(){
		double totalValue = CURRENCE;
		for(String code : mData.keySet()){
			totalValue += printSto(code);
		}
		System.out.printf("Total Value: %f\n", totalValue);
	}
}
