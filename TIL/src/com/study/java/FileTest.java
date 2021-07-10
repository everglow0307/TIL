package com.study.java;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {

	public static class ImageNameFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".jpg");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("D: 드라이브의 전체 파일 출력");
		File file = new File("D:\\");
		String[] files = file.list();
		for(String fileName : files) {
			File subFile = new File(file, fileName);
			if(file.isDirectory()) {
				System.out.println("디렉토리 이름: "+fileName);
			}else {
				System.out.println("파일이름:"+fileName+", 파일크기:"+subFile.length()+"byte");
			}
		}//end for
		
		System.out.println("C:드라이브의 이미지 파일만 출력");
		String[] imageFiles = file.list(new ImageNameFilter());
		
		for(String fileName: imageFiles) {
			File subFile = new File(file, fileName);
			System.out.println("파일 이름 : "+fileName+",파일 크기: "+subFile.length()+"byte, 파일경로:"+subFile.getAbsolutePath());
		}
		
		File makeFile = new File("D:\\blog\\jeongjisu.txt");
		try {
			makeFile.createNewFile();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(makeFile.exists()) {
			System.out.println("makeFile생성됨.");
		}
		
		File renameFile = new File("D:\\blog\\jisujisu.txt");
		makeFile.renameTo(renameFile);
		if(renameFile.exists()) {
			System.out.println("이름 변경됨.");
		}
		
		if(renameFile.delete()) {
			System.out.println("제거됨.");
		}
	}
}
