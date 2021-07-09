package com.study.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lambda {

	public static void main(String[] args) {

	//	Object obj = (a, b) -> a > b ? a : b	//람다식. 익명객체
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b? a:b;
			}
		};
		
		//int value = obj.max(3,5);
		// 실제 object안에는 max메서드가 없기 때문에 호출할 수가 없음.
		
		//함수형 인터페이스 - 단 하나의 추상메서드만 선언된 인터페이스
		MyFunction f = new MyFunction() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		int value = f.max(3, 5); //MyFunction에 max가 있음
		
		//람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f2 = (a, b) -> a > b ? a : b;
		
		//람다식은 이름이 없지만 실제로 호출하기 위해서는 이름이 필요하므로 interface에서 이름을 지정해줘야 한다.
		int value2 = f2.max(3, 5); 
		
		
		//함수형 인터페이스 종류
		Supplier<Integer> s = () -> (int)(Math.random()*100+1);
		Consumer<Integer> c = i -> System.out.print(i+", ");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer, Integer> f9 = i -> i/10*10;
		
		
		
		
	}
}
