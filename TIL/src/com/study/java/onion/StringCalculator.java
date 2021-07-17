package com.study.java.onion;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class StringCalculator {

	/**
	 * �䱸����1. ��ǥ,�ݷ��� �����ڷ� ���ڿ��� �и��ؼ� ������ �� ��ȯ�ϱ�
	 * 
	 * �䱸����2. Ŀ���� ������ ��밡��: ����) //;\n������ ������ ����(;�� Ŀ���� �����ڿ� �ش�)
	 * 
	 * �䱸����3. ������ ������ ��� RuntimeException���� ���� ó��
	 * 
	 * */
	
	//���� § �ڵ�
	/**
	 * comment1: ���� �޼ҵ� ����غ���� �ߴ��� �����ϴ�.
	 * comment2: ���ڿ�, �����ϳ��� �Է����� ���� ������� �ʾҴ�.
	 * */
	public int calculator(String str) {
		
		String delimiter = ":|,";
		if(str.startsWith("//")) {
			String add = str.substring(2,str.indexOf("\n"));
			str = str.substring(str.indexOf("\n")+1);
			delimiter = delimiter.concat("|"+add);
		}
		
		String[] strArr = str.split(delimiter);
		int[] intArr = new int[strArr.length];
		
		for(int i=0;i<strArr.length;i++) {
			int num = Integer.parseInt(strArr[i]);
			if(num<0) {
				throw new RuntimeException("customized Exception");
			}else {
				intArr[i] = num;	
			}
		}
		
		IntStream intstr = Arrays.stream(intArr);
		int result = intstr.sum();
		
		return result;
	}
	
	// å���� § �ڵ�
	/**
	 * �ϳ��� �޼ҵ�� �ϳ��� ��ɸ� �ϵ���
	 * public method�� ��������.
	 * */
	public int add(String text) {
		if(isBlank(text)) {
			return 0;
		}
			return sum(toInts(split(text)));
	}
	
	//���ڿ� �Ǵ� nullüũ
	private boolean isBlank(String text) {
		return text==null || text.isEmpty();
	}
	
	//�����ڷ� �и�
	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		return text.split(",|:");
	}
	
	//�հ�
	private int sum(int[] values) {
		int sum = 0;
		
		for(int value : values) {
			sum += value;
		}
		return sum;
	}
	
	//���ڿ��� ���ڷ� ��ȯ
	private int[] toInts(String[] values) {
		int[] intValues = new int[values.length];
		
		for(int i=0; i<intValues.length; i++) {
			intValues[i] = toPositive(values[i]);
		}
		
		return intValues;
	}
	
	//���� �Է½� runtime���� �߻�
	public int toPositive(String value) {
		int number = Integer.parseInt(value);
		if(number < 0) {
			throw new RuntimeException();
		}
		return number;
	}
}
