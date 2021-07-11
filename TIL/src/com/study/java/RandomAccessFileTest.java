package com.study.java;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	
	/**
	 * RandomAccessFileŬ������ �����͸� �����鼭 ���ÿ� ����ϴ� ����� ����.
	 * pointer�� ����ؼ� �۾��� ��ġ�� �����Ӱ� ������ �� �ִ�.
	 * */
	
	public static void main(String[] args) {
		
		RandomAccessFile raf = null;
		
		try {
			//�а� ���� ���� ����
			raf = new RandomAccessFile("random.txt","rw");
			
			System.out.println("���� ���� ������: "+raf.getFilePointer());
			
			raf.writeInt(75);
			raf.writeBoolean(false);
			raf.writeChar('A');
			raf.writeLong(100);
			
			System.out.println("������ ��� �� ���� ������: "+raf.getFilePointer());
			
			//����� ������ ũ�⸸ŭ �����Ͱ� �̵��Ǿ� �ִµ�, seek�� ó������ ���� �� �ֵ��� ������ ����.
			raf.seek(0);
			
			System.out.println("int�� ���: "+raf.readInt());
			System.out.println("boolean�� ���: "+raf.readBoolean());
			
			raf.skipBytes(2);
			System.out.println("long�� ���: "+raf.readLong());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
