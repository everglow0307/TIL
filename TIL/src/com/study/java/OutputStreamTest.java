package com.study.java;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {

	public static void main(String[] args) {
		
		/**
		 * FileOutputStream테스트
		 * 
		 * -지정한 경로에 대상 파일이 없으면 자동으로 파일을 생성해 주고, 디렉터리 자체가 존재하지 않으면 FileNotFoundException예외를 발생시킨다.
		 * */
		FileOutputStream fo = null;
		
		String msg = "FileOutputStream test입니다.";
		byte[] byteArray = msg.getBytes();
		
		try {
			fo = new FileOutputStream("fileoutput.txt", true);
			fo.write(byteArray);
			
		}catch(IOException io) {
			io.printStackTrace();
		}finally {
			try {
				fo.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * ByteArrayOutputStream테스트
		 * */
		String msg2 = "ByteArrayOutputStream test";
		ByteArrayOutputStream bao = null;
		
		try {
			bao = new ByteArrayOutputStream();
			bao.write(msg2.getBytes());
			System.out.println("bao="+bao);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bao.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
