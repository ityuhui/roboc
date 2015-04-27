package com.yuhui.roboc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchUtil {
	
	private final static String BASEURL = "http://xueqiu.com/S/";
	
	private final static Map mData = new HashMap<String,StockItem>(){
		{
			put("SZ002340",new StockItem("SZ002340",1800,18.379));
			put("SH600660",new StockItem("SH600660",1100,16.239));
		}
		
	};
	
	public static void printSto(String code){
		Document doc;
		try {
			String url = BASEURL + code ;
			doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Element name = doc.select(".stockName").first();
			Element cp1 = doc.select("div.currentInfo strong").first();
			String cp2 = cp1.attr("data-current");
			
			Element qp = doc.select(".quote-percentage").first();
			String output = name.text() + ":" + cp2 + ":" + qp.text();
			System.out.println(output);
			
			StockItem si = (StockItem)mData.get(code);
			
			double cpv = Double.parseDouble(cp2) - si.getCost();
			double rate = cpv / si.getCost() * 100.0;
			System.out.printf("%+.2f%%\n",rate);
			System.out.printf("%.2f\n",si.getHold() * cpv);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
