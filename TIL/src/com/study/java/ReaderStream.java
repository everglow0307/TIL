package com.study.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReaderStream {

	/**
	 * �ڹٿ��� ���� ��� ����� ����� �����ϱ� ���ؼ� ReaderŬ����(InputStream�� ����)�� WriterŬ����(OutputStream�� ����)�� ����
	 * 
	 * - ����Ʈ ��� ��Ʈ������ �ѱ� ó���� ������ �߻��� ����� �����Ƿ� ���ڱ�� ��Ʈ���� ����ϵ��� �Ѵ�.
	 * */
	
	/**
	 * BufferedReaderŬ������ Reader��Ʈ���� ���� ����� �߰��ϴ� ��Ʈ�� Ŭ�����̴�.
	 * �����͸� ���� �� ���ۿ� �о��ٰ� ���۷κ��� �����͸� ���ʴ�� �о� ���̱� ������ ������ ������.
	 * ���� BufferedReaderŬ�������� readLine�̶�� �� ���κ��� �����͸� �о StringŸ������ �����͸� ��ȯ���ִ� �޼ҵ� ����
	 * */
	
	public static void main(String[] args) {
		// BufferedReader�׽�Ʈ
		FileInputStream fi = null;
		
		//InputStreamReader�� �Ķ���ͷ� ���� InputStream�� �̿��ؼ� Reader��ü�� �������ִ� Ŭ����
		InputStreamReader isr = null;
		
		//BufferedReader���� �䱸�ϴ� �Ķ���� Ÿ���� ReaderŸ���̱� ������ InputStreamReaderŬ������ ReaderŸ������ ��������.
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
			//FileInputStream�� ������ ����Ʈ ������ �о��.
			fi2 = new FileInputStream("address.txt");
			
			//"UTF-8"�� ������ ���ڵ� �ȵż� �ѱ� ����.
			is2 = new InputStreamReader(fi2, "UTF-8");
			br2 = new BufferedReader(is2);
			
			String str = null;
			while((str=br2.readLine())!=null) {
				st = new StringTokenizer(str, ",");
				System.out.println("�̸�: "+st.nextToken()+",�ּ�: "+st.nextToken()+",�̸���: "+st.nextToken()+",��ȭ��ȣ: "+st.nextToken());
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
		 * FileReader�� ���Ϸκ��� ���� ������ �����͸� ���� �� �ִ� ��Ʈ�� Ŭ����. InputStreamReaderŬ������ ��ӹ޴´�.
		 * FileReader�� ���ڵ� ������ �ȵȴ�... InputStreamReader(new FileInputStream(new File("path"),"utf-8"))
		 * 
		 * InputStreamReaderŬ������ ����Ʈ Ÿ������ �о� ���� �����͸� ����Ÿ������ �о���̱� ���� �����. �Ǵ� BufferedReaderó�� �Ķ���ͷ� Reader��ü�� �ʿ��Ҷ���..
		 * �ֿܼ��� �����͸� �о� ���� �� System.in�� �̿��ؼ� ���� �� �ѱ��� ����. �̸� InputStreamReader�� ó���� �� �ִ�.
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
