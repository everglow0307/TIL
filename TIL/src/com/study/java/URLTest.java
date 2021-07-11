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
	 * URL��ü�� �����Ǹ� openStream()���� �ش� URL�� �ڿ��� ��� ���� InputStream�� ���Ϲ��� �� ������, getConnection()�޼ҵ�� URLConnection��ü�� ��� �� �� �ִ�.
	 * URLConnectionŬ������ �߻�Ŭ�����̱� ������ �����ڷ� ��ü ���� �Ұ�.
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
		 * URL Connection ��ü�� �̿��ؼ� URL�� �ڿ��Ӹ� ����������� ���� �� �ִ�.
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
