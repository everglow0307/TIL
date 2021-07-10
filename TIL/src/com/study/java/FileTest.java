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
		System.out.println("D: ����̺��� ��ü ���� ���");
		File file = new File("D:\\");
		String[] files = file.list();
		for(String fileName : files) {
			File subFile = new File(file, fileName);
			if(file.isDirectory()) {
				System.out.println("���丮 �̸�: "+fileName);
			}else {
				System.out.println("�����̸�:"+fileName+", ����ũ��:"+subFile.length()+"byte");
			}
		}//end for
		
		System.out.println("C:����̺��� �̹��� ���ϸ� ���");
		String[] imageFiles = file.list(new ImageNameFilter());
		
		for(String fileName: imageFiles) {
			File subFile = new File(file, fileName);
			System.out.println("���� �̸� : "+fileName+",���� ũ��: "+subFile.length()+"byte, ���ϰ��:"+subFile.getAbsolutePath());
		}
		
		File makeFile = new File("D:\\blog\\jeongjisu.txt");
		try {
			makeFile.createNewFile();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(makeFile.exists()) {
			System.out.println("makeFile������.");
		}
		
		File renameFile = new File("D:\\blog\\jisujisu.txt");
		makeFile.renameTo(renameFile);
		if(renameFile.exists()) {
			System.out.println("�̸� �����.");
		}
		
		if(renameFile.delete()) {
			System.out.println("���ŵ�.");
		}
	}
}
