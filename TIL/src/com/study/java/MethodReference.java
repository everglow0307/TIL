package com.study.java;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

	/**
	 * 하나의 메서드만 호출하는 람다식은 메서드 참조로 간단히 할 수 있다.
	 * 
	 * 메서드 참조는 클래스 이름::메서드 이름
	 * */
	
	/**static 메서드 참조
	 * Integer method(String s){
	 *     return Integer.parseInt(s);
	 * }
	 * 
	 * Function<String, Integer> f = (String s) -> Integer.parseInt(s);
	 * 람다식으로 표현한 위 코드는 사실 참조변수만 봐도 인자값의 데이터 타입과 반환값을 알 수 있기 때문에 생략하고
	 * 클래스이름과 메서드 이름만 남겨서 간단하게 사용할 수 있다.
	 * 
	 * Function<String, Integer> f = Integer::parseInt;
	 * 
	 * */
	public static void main(String[] args) {
		//Function<String,Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f = Integer::parseInt;	//메서드 참조
		
		System.out.println(f.apply("100")+200);
		
		
		// 생성자의 메서드 참조
		// Supplier<MyClass> s = () -> new MyClass();
		// Supplier<MyClass> s = MyClass:new;
		
		// 배열과 메서드 참조
		// Function<Integer, int[]> f = x -> new int[x];
		// Function<Integer, int[]> f2 = int[]::new;
		
		//Supplier<MyClass> s = () -> new MyClass();
		Supplier<MyClass> s = MyClass::new;
		Function<Integer, MyClass> s2 = MyClass::new;
		
		MyClass mc = s.get();
		System.out.println(mc);
		System.out.println(s2.apply(100).iv);
		
		
		//Function<Integer, int[]> f3 = (i) -> new int[i];
		Function<Integer, int[]> f3 = int[]::new;
		
		System.out.println(f3.apply(100).length);
		
		
		
		
		
		
		
	}
	
	
}

class MyClass{
	
	int iv;
	
	MyClass(){
		
	}
	MyClass(int iv){
		this.iv = iv;
	}
}