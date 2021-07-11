package com.study.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReaderStream {

	/**
	 * 자바에서 문자 기반 입출력 기능을 제공하기 위해서 Reader클래스(InputStream과 대응)와 Writer클래스(OutputStream과 대응)를 제공
	 * 
	 * - 바이트 기반 스트림으로 한글 처리시 문제바 발생할 우려가 있으므로 문자기반 스트림을 사용하도록 한다.
	 * */
	
	/**
	 * BufferedReader클래스는 Reader스트림에 버퍼 기능을 추가하는 스트림 클래스이다.
	 * 데이터를 읽을 때 버퍼에 읽었다가 버퍼로부터 데이터를 차례대로 읽어 들이기 때문에 성능이 좋아짐.
	 * 또한 BufferedReader클래스에는 readLine이라는 한 라인별로 데이터를 읽어서 String타입으로 데이터를 반환해주는 메소드 존재
	 * */
	
	public static void main(String[] args) {
		// BufferedReader테스트
		FileInputStream fi = null;
		
		//InputStreamReader는 파라미터로 받은 InputStream을 이용해서 Reader객체를 생성해주는 클래스
		InputStreamReader isr = null;
		
		//BufferedReader에서 요구하는 파라미터 타입이 Reader타입이기 때문에 InputStreamReader클래스가 Reader타입으로 변경해줌.
		BufferedReader bfr = null;
		
		try {
			fi = new FileInputStream("bufferReader.txt");
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			
			String str = null;
			while((str=bfr.readLine())!=null) {
				System.out.println(str);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
				isr.close();
				bfr.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//=====================================================================================
		
		FileInputStream fi2 = null;
		InputStreamReader is2 = null;
		BufferedReader br2 = null;
		StringTokenizer st = null;
		
		try {
			//FileInputStream은 파일을 바이트 단위로 읽어옴.
			fi2 = new FileInputStream("address.txt");
			
			//"UTF-8"안 넣으면 인코딩 안돼서 한글 깨짐.
			is2 = new InputStreamReader(fi2, "UTF-8");
			br2 = new BufferedReader(is2);
			
			String str = null;
			while((str=br2.readLine())!=null) {
				st = new StringTokenizer(str, ",");
				System.out.println("이름: "+st.nextToken()+",주소: "+st.nextToken()+",이메일: "+st.nextToken()+",전화번호: "+st.nextToken());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fi2.close();
				is2.close();
				br2.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//==================================================================================
		
		/**
		 * FileReader는 파일로부터 문자 단위로 데이터를 읽을 수 있는 스트림 클래스. InputStreamReader클래스를 상속받는다.
		 * FileReader는 인코딩 설정이 안된다... InputStreamReader(new FileInputStream(new File("path"),"utf-8"))
		 * 
		 * InputStreamReader클래스는 바이트 타입으로 읽어 들인 데이터를 문자타입으로 읽어들이기 위해 사용함. 또는 BufferedReader처럼 파라미터로 Reader객체가 필요할때나..
		 * 콘솔에서 데이터를 읽어 들일 때 System.in을 이용해서 읽을 때 한글이 깨짐. 이를 InputStreamReader로 처리할 수 있다.
		 * 
		 * */
		
		FileReader fr = null;
		try {
			fr = new FileReader("address.txt");
			int readChar = -1;
			while((readChar=fr.read())!=-1) {
				System.out.println((char)readChar);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
	
}
