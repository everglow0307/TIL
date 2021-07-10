package com.study.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrac {

	//�پ��� �����ͼҽ�(�÷���, �迭)�� ǥ��ȭ�� ������� �ٷ�� ���� ��. 
	// Stream����, �߰� ����, ��������
	// ��Ʈ���� ������ �ҽ��κ��� �����͸� �б⸸�� �� �������� ����.
	// ��Ʈ���� Iteratoró�� ��ȸ���̴�. �ʿ��ϸ� �ٽ� �����ؾ� ��. 
	// ���� ���� ������ �߰������� ������� �ʴ´�. - ��������
	// ����ڽ̵� �� �ɸ��� �ð��� �Ҹ� ���̱� ���� �⺻�� ��Ʈ���� ����- IntStream, LongStream ���
	
	public static void main(String[] args) {

		//1. ��Ʈ�� ����� - �÷���
		// - Collection�������̽�(�̸� �����ϴ� List/ Set)�� stream()���� �÷����� ��Ʈ������ ��ȯ
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();  
				
		intStream.forEach(System.out::print);
		
		//stream�� ��ȸ���̶� �� �� ���Ǹ� ������ ������ �ٽ� �����ؼ� ����ؾ� ��.
		intStream = list.stream(); 
		intStream.forEach(System.out::print);
		
		//2. ��Ʈ�� ����� - �迭
		/**
		 * Stream<T> Stream.of(T...values) //���� ����
		 * Stream<T> Stream.of(T[])
		 * Stream<T> Arrays.stream(T[])
		 * Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
		 * */
		
		String[] strArr = new String[] {"a","b","c","d"};
		Stream<String> strStream = Stream.of("a","b","c");
		
		strStream.forEach(System.out::println);
		
		Stream<String> str2 = Arrays.stream(strArr);
		str2.forEach(System.out::println);
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream2 = Arrays.stream(intArr);
//		intStream2.forEach(System.out::println);
//		System.out.println("count="+intStream2.count()); //��������
		System.out.println("sum="+intStream2.sum());
		
		
		// 3. ��Ʈ�� ����� - ������ ��
		// ���� ��Ʈ�� ���� -> ints(), longs(), doubles()
		// ���� ��Ʈ���� ���� ��Ʈ������ �����ϴ� ���: ints(5) :ũ�Ⱑ 5�� ��Ʈ�� ��ȯ
		
		IntStream intStream3 = new Random().ints();  //���� ��Ʈ������
		intStream3.limit(5).forEach(System.out::println);  //5�� ��Ҹ� ���
		System.out.println();
		
		IntStream intStream4 = new Random().ints(5); //5���� ������
		intStream4
//		.limit(5)
		.forEach(System.out::println);
		
		IntStream intStream5 = new Random().ints(5, 10); //5���� 9������ ������ ����
		intStream5.limit(5).forEach(System.out::println);
		
		
		// 4. ���ٽ����� ��Ʈ�� �����
		// iterate(), generate()

		// iterate�� ���� ��Ҹ� seed�� �ؼ� ������Ҹ� ���.
		Stream<Integer> evenStream = Stream.iterate(1, n->n+2);  //0 2 4 6 ...
		evenStream.limit(10).forEach(System.out::println);
		
		// generate�� seed�� ������� ����.
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream.limit(10).forEach(System.out::println);
		
		
		// ���ϰ� �� ��Ʈ�� �����
		
		
		
		
		
		
		
		
		
		
		
	}
}
