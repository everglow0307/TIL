package com.study.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lambda {

	public static void main(String[] args) {

	//	Object obj = (a, b) -> a > b ? a : b	//���ٽ�. �͸�ü
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b? a:b;
			}
		};
		
		//int value = obj.max(3,5);
		// ���� object�ȿ��� max�޼��尡 ���� ������ ȣ���� ���� ����.
		
		//�Լ��� �������̽� - �� �ϳ��� �߻�޼��常 ����� �������̽�
		MyFunction f = new MyFunction() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		int value = f.max(3, 5); //MyFunction�� max�� ����
		
		//���ٽ��� �ٷ�� ���� ���������� Ÿ���� �Լ��� �������̽��� �Ѵ�.
		MyFunction f2 = (a, b) -> a > b ? a : b;
		
		//���ٽ��� �̸��� ������ ������ ȣ���ϱ� ���ؼ��� �̸��� �ʿ��ϹǷ� interface���� �̸��� ��������� �Ѵ�.
		int value2 = f2.max(3, 5); 
		
		
		//�Լ��� �������̽� ����
		Supplier<Integer> s = () -> (int)(Math.random()*100+1);
		Consumer<Integer> c = i -> System.out.print(i+", ");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer, Integer> f9 = i -> i/10*10;
		
		
		
		
	}
}
