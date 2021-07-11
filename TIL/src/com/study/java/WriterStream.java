package com.study.java;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriterStream {
	
	/**
	 * FileWriter�׽�Ʈ
	 * */
	public static void main(String[] args) {
		
		FileWriter fw = null;
		String msg = "FileWriter�׽�Ʈ�Դϴٿ�. ";
		try {
			fw = new FileWriter("fileWriter.txt",true);
			fw.write(msg);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//=================================================
		/**
		 * BufferedWriterŬ�������� flush����� �����Ǿ� �ֱ� ������ flush�� ����� �����͵��� ���������� ��µȴ�.
		 * Buffer�� ������� �����͸� �� ���� ����ϸ� flush���� �ʾƵ� �ڵ�flushó���� ��.�׷��� ���ۻ���� �ʰ����� �ʴ� �����Ͱ� �� ������ �ڵ� flush���� �ʴ´�.
		 * */
		
		FileWriter fileW = null;
		BufferedWriter buw =null;
		
		try {
			fileW = new FileWriter("bufferWriter.txt");
			
			//���ۻ����� 4������. 4���ں��� ���� ����� ���� �ڵ����� flush�ȴ�.
			//����� ���� ���ۻ���� �ʰ����� �ʾƼ� �ڵ� flush���� ����.��� ���Ͽ� �ƹ��͵� ��µ��� �ʴ´�.
			// �����͸� ����Ϸ��� flush�� �ϰų� bufferedWriter�� �ݾ��ش�. �ݾ��ָ� �÷����ϰ� �ݾ��ֱ� ����.
			buw = new BufferedWriter(fileW, 4);
			buw.write("A");
			buw.newLine();
			buw.write("B");
			buw.write("C");
			buw.write("D");
			
			//buw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				buw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//============================================================================
		/**
		 * OutputStreamWriterŬ������ ����Ʈ ��� ��� ��Ʈ���� ���ڱ�� ��½�Ʈ������ ��ȯ�� �� �ִ� ����� ����.
		 * ��Ʈ��ũ ���α׷��� ��� ������ ����ؼ� ���� ������ �����͸� ����Ϸ��� OutputStreamWriter�� ��ȯ �۾��� �ؾ� �Ѵ�.
		 * 
		 * ==================OutputStreamWriter�׽�Ʈ===================================
		 * */

		FileOutputStream fileOutputS = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffW = null;
		
		try {
			fileOutputS = new FileOutputStream("outputStream.txt");
			outWriter = new OutputStreamWriter(fileOutputS, "utf-8");
			buffW = new BufferedWriter(outWriter);
			
			buffW.write("OutputStreamWriter �׽�Ʈ");
			buffW.newLine();
			buffW.write("OutputStreamWriter �׽�Ʈ ");
			buffW.newLine();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				buffW.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
		

}
