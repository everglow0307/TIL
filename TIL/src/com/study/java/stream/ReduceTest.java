package com.study.java.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {

	/**
	 * ��Ʈ���� ��������
	 * - ��Ʈ���� ��Ҹ� �ϳ��� �ٿ����� �������� ���� - reduce()
	 * 
	 * identity : �ʱⰪ
	 * accumulator : ���� �������� ��Ʈ���� ��ҿ� ������ ����
	 * combiner : ����ó���� ����� ��ġ�µ� ����� ����(���� ��Ʈ��)
	 * 
	 * 
	 * int sum = intStream.reduce(0, (a,b) -> a+b ); 
	 * 
	 * int a = identity;
	 * 
	 * for(int b : stream)
	 * 	 	a = a + b;  //sum() 
	 * */
	public static void main(String[] args) {
		
		String[] strArr = {
				"java", "lambda", "stream", "IntStream", "count", "some"
		};
		
		Stream.of(strArr)
		.parallel()
		.forEachOrdered(System.out::println);
		
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
		
		Optional<String> sWord = Stream.of(strArr).parallel()
				.filter(s->s.charAt(0)=='s').findAny();
		
		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWord="+sWord.get());
		
		
		//Stream<String>�� Stream<Integer>���� ��ȯ
		Stream<Integer> intStream2 = Stream.of(strArr).map(String::length);
		
		
		//Stream<String>�� IntStream���� ��ȯ
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream5 = Stream.of(strArr).mapToInt(String::length);
		
		
		int count = intStream1.reduce(0,(a,b)->a+1);
		int sum = intStream2.reduce(0, (a,b)->a+b);
		
		
		//�Ʒ��� reduce�� �ʱⰪ���� accumulator�� �־��µ�, intStream3�� ���� ���� �� �ֱ� ������ 
		// �޴� ���������� Ÿ���� OptionalInt�� �� ����.
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = IntStream.empty().reduce(Integer::min);
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+max.getAsInt());
		System.out.println("min="+min.orElse(0));
		
		
		
		
		
		
		
	}
}
