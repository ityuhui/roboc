package com.yuhui.roboc;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainApp {

	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("http://xueqiu.com/S/SZ002340").get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
