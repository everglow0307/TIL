package com.study.java;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {

	public static void main(String[] args) {
		
		/**
		 * FileOutputStream�׽�Ʈ
		 * 
		 * -������ ��ο� ��� ������ ������ �ڵ����� ������ ������ �ְ�, ���͸� ��ü�� �������� ������ FileNotFoundException���ܸ� �߻���Ų��.
		 * */
		FileOutputStream fo = null;
		
		String msg = "FileOutputStream test�Դϴ�.";
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
		 * ByteArrayOutputStream�׽�Ʈ
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
