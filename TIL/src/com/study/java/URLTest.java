package com.study.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	/**
	 * java.net.URL
	 * 
	 * URL객체가 생성되면 openStream()으로 해당 URL의 자원을 얻어 오는 InputStream을 리턴받을 수 있으며, getConnection()메소드로 URLConnection객체도 얻어 올 수 있다.
	 * URLConnection클래스는 추상클래스이기 때문에 생성자로 객체 생성 불가.
	 * */
	
	public static void main(String[] args) {
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			URL url = new URL("http://everglow0307.github.io/Portfolio");
			is = url.openStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
	
			String str = "";
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				isr.close();
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//===========================================================
		/**
		 * URL Connection 객체를 이용해서 URL의 자원뿐만 헤더정보까지 얻어올 수 있다.
		 * */
		
		InputStream is2 = null;
		InputStreamReader isr2 = null;
		BufferedReader br2 = null;
		
		try {
			URL url = new URL("http://www.google.com");
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			
			String str = "";
			String contentType = conn.getContentType();
			System.out.println("ContentType: "+contentType);
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				isr.close();
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}
