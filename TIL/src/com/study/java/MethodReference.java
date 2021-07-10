package com.study.java;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

	/**
	 * �ϳ��� �޼��常 ȣ���ϴ� ���ٽ��� �޼��� ������ ������ �� �� �ִ�.
	 * 
	 * �޼��� ������ Ŭ���� �̸�::�޼��� �̸�
	 * */
	
	/**static �޼��� ����
	 * Integer method(String s){
	 *     return Integer.parseInt(s);
	 * }
	 * 
	 * Function<String, Integer> f = (String s) -> Integer.parseInt(s);
	 * ���ٽ����� ǥ���� �� �ڵ�� ��� ���������� ���� ���ڰ��� ������ Ÿ�԰� ��ȯ���� �� �� �ֱ� ������ �����ϰ�
	 * Ŭ�����̸��� �޼��� �̸��� ���ܼ� �����ϰ� ����� �� �ִ�.
	 * 
	 * Function<String, Integer> f = Integer::parseInt;
	 * 
	 * */
	public static void main(String[] args) {
		//Function<String,Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f = Integer::parseInt;	//�޼��� ����
		
		System.out.println(f.apply("100")+200);
		
		
		// �������� �޼��� ����
		// Supplier<MyClass> s = () -> new MyClass();
		// Supplier<MyClass> s = MyClass:new;
		
		// �迭�� �޼��� ����
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