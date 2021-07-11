package com.study.java;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	
	/**
	 * RandomAccessFile클래스는 데이터를 읽으면서 동시에 출력하는 기능을 제공.
	 * pointer를 사용해서 작업할 위치를 자유롭게 조절할 수 있다.
	 * */
	
	public static void main(String[] args) {
		
		RandomAccessFile raf = null;
		
		try {
			//읽고 쓰기 모드로 생성
			raf = new RandomAccessFile("random.txt","rw");
			
			System.out.println("시작 파일 포인터: "+raf.getFilePointer());
			
			raf.writeInt(75);
			raf.writeBoolean(false);
			raf.writeChar('A');
			raf.writeLong(100);
			
			System.out.println("데이터 출력 후 파일 포인터: "+raf.getFilePointer());
			
			//출력한 데이터 크기만큼 포인터가 이동되어 있는데, seek로 처음부터 읽을 수 있도록 포인터 돌림.
			raf.seek(0);
			
			System.out.println("int값 출력: "+raf.readInt());
			System.out.println("boolean값 출력: "+raf.readBoolean());
			
			raf.skipBytes(2);
			System.out.println("long값 출력: "+raf.readLong());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
