package com.study.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaPrac {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("thread����");
		}).start(); 
		
		// java.util.function�� �ִ� �Լ��� �������̽�
		// 1.Consumer<T> void accept(T t)
		Consumer<String> c = name -> System.out.println(name+"hello");
		c.accept("Ji Su");
		
		//BiConsumer<T,U>
		BiConsumer<String, Integer> bc = (name, age) -> System.out.println("name: "+name+",age: "+age);
		bc.accept("Ji Su", 27);
		
		//IntConsumer
		IntConsumer ic = page -> System.out.println("open the bookpage."+page);
		ic.accept(26);
		
		// 2. Supplier<T> T get()
		Supplier<String> s = () -> "Four years no call";
		String result = s.get();
		System.out.println(result);
		
		
		// 3. Function<T, R> R apply(T t)
		Function<Integer, String> integerToString = num -> {return Integer.toString(num);};
		String result2 = integerToString.apply(100);
		System.out.println(result2);
		

		// 4. Predicate<T> boolean test(T t)
		Predicate<String> bp = str1 -> str1.equals("��");
		boolean result3 = bp.test("��");
		System.out.println(result3);
		
		//Predicate���� 
		/**
		 * - and(), or(), negate()�� �� predicate�� �ϳ��� ����(default�޼ҵ�)
		 * - ��񱳸� ���� �ۼ� �ÿ��� isEqual()�� ���(static�޼���)
		 * */
		
		Predicate<Integer> p = i -> i<100;
		Predicate<Integer> q = i -> i <200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result5 = p2.test(str2);
		System.out.println(result5);
		
		
		// �÷��� �����ӿ�ũ�� �Լ��� �������̽�
		//1. boolean removeIf(Predicate<E> filter) : ���ǿ� �´� ��� ����
		//2. void replaceAll(UnaryOperator<E> operator) : ��� ��Ҹ� ��ȯ�Ͽ� ��ü
		//3. (Iterable) void forEach(Consumer<T> action) :��� ��ҿ� �۾� action�� ����
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3,4,5));
		
		
		list.forEach(i -> System.out.print(i+", "));
		System.out.println();
		
		list.removeIf(x -> x%2==0 || x%3 ==0);
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		
				
	}
}
