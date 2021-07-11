package com.study.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamTest {

	/**
	 * 자바에서는 바이트 기반으로 입출력하는 스트림 제공 이외에 기본 데이터 타입으로 입출력할 수 있는 형태의 DataOutput/ DataInput인터페이스를 구현하는 클래스들을 제공한다.
	 * 이 클래스들은 각각 FilterOutputStream과 FilterInputStream클래스들을 상속하고 있으므로(특정 기능을 추가해주는 역할) 객체를 생성할 때 특정 기능을 추가할 대상 스트림 객체를 필요로 함. 
	 * */
	
	public static void main(String[] args) {
		FileOutputStream fo = null;
		FileInputStream fi = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			
			fo = new FileOutputStream("dataFile.txt");
			fi = new FileInputStream("dataFile.txt");
			dos = new DataOutputStream(fo);
			dis = new DataInputStream(fi);
			
			dos.writeShort(-1);
			dos.writeByte(2);
			dos.writeDouble(3.14);
			dos.writeLong(30);
			dos.writeUTF("datastream test");
			
			System.out.println(dis.readUnsignedShort());
			dis.skip(1);
			System.out.println(dis.readDouble());
			System.out.println(dis.readLong());
			System.out.println(dis.readUTF());
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				fi.close();
				fo.close();
				dis.close();
				dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
