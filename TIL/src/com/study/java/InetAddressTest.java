package com.study.java;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		
		InetAddress ia = null;
		
		try {

			//ip주소 알아내기
			ia = InetAddress.getLocalHost();
			System.out.println(ia);
			
			InetAddress[] aIa = InetAddress.getAllByName("www.naver.com");
			
			for(int i=0; i<aIa.length ;i++) {
				System.out.println(aIa[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
