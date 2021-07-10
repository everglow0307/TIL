package com.study.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrac {

	//다양한 데이터소스(컬렉션, 배열)를 표준화된 방법으로 다루기 위한 것. 
	// Stream생성, 중간 연산, 최종연산
	// 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않음.
	// 스트림은 Iterator처럼 일회용이다. 필요하면 다시 생성해야 함. 
	// 최종 연산 전까지 중간연산이 수행되지 않는다. - 지연연산
	// 오토박싱될 때 걸리는 시간적 소모를 줄이기 위해 기본형 스트림도 제공- IntStream, LongStream 등등
	
	public static void main(String[] args) {

		//1. 스트림 만들기 - 컬렉션
		// - Collection인터페이스(이를 구현하는 List/ Set)의 stream()으로 컬렉션을 스트림으로 변환
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();  
				
		intStream.forEach(System.out::print);
		
		//stream은 일회용이라 한 번 사용되면 닫히기 때문에 다시 생성해서 사용해야 함.
		intStream = list.stream(); 
		intStream.forEach(System.out::print);
		
		//2. 스트림 만들기 - 배열
		/**
		 * Stream<T> Stream.of(T...values) //가변 인자
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
//		System.out.println("count="+intStream2.count()); //최종연산
		System.out.println("sum="+intStream2.sum());
		
		
		// 3. 스트림 만들기 - 임의의 수
		// 무한 스트림 생성 -> ints(), longs(), doubles()
		// 무한 스트림을 유한 스트림으로 생성하는 방법: ints(5) :크기가 5인 스트림 반환
		
		IntStream intStream3 = new Random().ints();  //무한 스트림생성
		intStream3.limit(5).forEach(System.out::println);  //5개 요소만 출력
		System.out.println();
		
		IntStream intStream4 = new Random().ints(5); //5개만 나오게
		intStream4
//		.limit(5)
		.forEach(System.out::println);
		
		IntStream intStream5 = new Random().ints(5, 10); //5부터 9까지의 범위로 지정
		intStream5.limit(5).forEach(System.out::println);
		
		
		// 4. 람다식으로 스트림 만들기
		// iterate(), generate()

		// iterate는 이전 요소를 seed로 해서 다음요소를 계산.
		Stream<Integer> evenStream = Stream.iterate(1, n->n+2);  //0 2 4 6 ...
		evenStream.limit(10).forEach(System.out::println);
		
		// generate는 seed를 사용하지 않음.
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream.limit(10).forEach(System.out::println);
		
		
		// 파일과 빈 스트림 만들기
		
		
		
		
		
		
		
		
		
		
		
	}
}
