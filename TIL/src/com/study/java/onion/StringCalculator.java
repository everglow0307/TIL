package com.study.java.onion;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class StringCalculator {

	/**
	 * 요구사항1. 쉼표,콜론의 구분자로 문자열을 분리해서 숫자의 합 반환하기
	 * 
	 * 요구사항2. 커스텀 구분자 사용가능: 예시) //;\n사이의 구분자 가능(;이 커스텀 구분자에 해당)
	 * 
	 * 요구사항3. 음수를 전달할 경우 RuntimeException으로 예외 처리
	 * 
	 * */
	
	//내가 짠 코드
	/**
	 * comment1: 여러 메소드 사용해볼라고 했더니 조잡하다.
	 * comment2: 빈문자열, 숫자하나만 입력했을 때를 고려하지 않았다.
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
	
	// 책에서 짠 코드
	public int add(String text) {
		if("".equals(text)) {
			return 0;
		}
		
		/**
		 * 정규표현식에서 . 는 임의의 한 문자를 의미하고, ()는 그룹화를 의미
		 * .*는 임의의 한 문자가 0이거나 0보다 많음을 의미.
		 * */
		
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		
		if(m.find()) {
			String customDelimeter = m.group(1);
			String[] tokens = m.group(2).split(customDelimeter);
		}
		
		
		return 0;
	}
}
