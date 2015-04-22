package com.yuhui.roboc;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchUtil {
	
	private final static String BASEURL = "http://xueqiu.com/S/"; 
	
	public void printSto(String code){
		Document doc;
		try {
			String url = BASEURL + code ;
			doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Element name = doc.select(".stockName").first();
			Element cp = doc.select(".stockUp").first();
			String output = name.text() + ":" + cp.text();
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
