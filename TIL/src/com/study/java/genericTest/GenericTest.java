package com.study.java.genericTest;

import java.util.ArrayList;

public class GenericTest{
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30");
		
		//실제 값은 String임에도 컴파일시에 Integer로 다운캐스팅해도 에러가 발생하지 않는다.
		//runtime시에 ClassCastException이 발생한다.
		/**
		 * list.get(2)의 반환타입은 Object이기 때문에 컴파일당시에는 에러가 발생하지 않는다. 
		 * */
		Integer i = (Integer)list.get(2);
		
		System.out.println(list);
		
		//때문에 지네릭스를 사용하면 컴파일시에 타입체크를 할 수 있고, 꺼낼때도 형변환을 생략할 수 있다.
	}
}