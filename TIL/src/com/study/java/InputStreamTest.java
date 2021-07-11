package com.study.java;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class InputStreamTest {
	public static void main(String[] args) {
		int var_byte = -1;
		
//		do {
//			try {
//				System.out.print("입력: ");
//				var_byte = System.in.read();
//				
//			}catch(IOException e) {
//				e.printStackTrace();
//				
//			}
//			
//			if(var_byte==10||var_byte==13) continue;
//			if(var_byte==-1) break;
//			System.out.println("읽은 값: "+(char)var_byte);
//		}while(true);
//		
		
		// FileInputStream 테스트
		FileInputStream fIn = null;
		
		try {
			fIn = new FileInputStream("D:\\blog\\test.txt");
		}catch(IOException io) {
			io.printStackTrace();
		}
		
		int var_read = -1;
		
		try {
			while((var_read = fIn.read())!=-1) {
				System.out.println((char)var_read);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fIn.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}//end finally
		
		
		/**
		 * ByteArrayInputStream
		 * - 메모리에 생성되어 있는 바이트 배열 객체에서 데이터를 읽어 들이는 역할을 하는 클래스
		 * */
		byte[] datas = new byte[] {10,20,30,40,50};
		ByteArrayInputStream bai = new ByteArrayInputStream(datas);
		int var_readType = -1;
		
		while((var_readType = bai.read())!= -1) {
			System.out.println(var_readType+" ");
		}
		
		
		
	}
}
