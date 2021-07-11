package com.study.java;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriterStream {
	
	/**
	 * FileWriter테스트
	 * */
	public static void main(String[] args) {
		
		FileWriter fw = null;
		String msg = "FileWriter테스트입니다요. ";
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
		 * BufferedWriter클래스에는 flush기능이 구현되어 있기 때문에 flush를 해줘야 데이터들이 최종적으로 출력된다.
		 * Buffer의 사이즈보다 데이터를 더 많이 출력하면 flush하지 않아도 자동flush처리가 됨.그러나 버퍼사이즈를 초과하지 않는 데이터가 들어가 있으면 자동 flush되지 않는다.
		 * */
		
		FileWriter fileW = null;
		BufferedWriter buw =null;
		
		try {
			fileW = new FileWriter("bufferWriter.txt");
			
			//버퍼사이즈 4로지정. 4문자보다 많이 출력할 때만 자동으로 flush된다.
			//결과를 보면 버퍼사이즈를 초과하지 않아서 자동 flush되지 않음.고로 파일에 아무것도 출력되지 않는다.
			// 데이터를 출력하려면 flush를 하거나 bufferedWriter를 닫아준다. 닫아주면 플러시하고 닫아주기 때문.
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
		 * OutputStreamWriter클래스는 바이트 기반 출력 스트림을 문자기반 출력스트림으로 변환할 수 있는 기능을 제공.
		 * 네트워크 프로그램의 경우 소켓을 사용해서 문자 단위로 데이터를 출력하려면 OutputStreamWriter로 변환 작업을 해야 한다.
		 * 
		 * ==================OutputStreamWriter테스트===================================
		 * */

		FileOutputStream fileOutputS = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffW = null;
		
		try {
			fileOutputS = new FileOutputStream("outputStream.txt");
			outWriter = new OutputStreamWriter(fileOutputS, "utf-8");
			buffW = new BufferedWriter(outWriter);
			
			buffW.write("OutputStreamWriter 테스트");
			buffW.newLine();
			buffW.write("OutputStreamWriter 테스트 ");
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
