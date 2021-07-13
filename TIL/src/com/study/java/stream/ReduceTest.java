package com.study.java.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {

	/**
	 * 스트림의 최종연산
	 * - 스트림의 요소를 하나씩 줄여가며 누적연산 수행 - reduce()
	 * 
	 * identity : 초기값
	 * accumulator : 이전 연산결과와 스트림의 요소에 수행할 연산
	 * combiner : 병렬처리된 결과를 합치는데 사용할 연산(병렬 스트림)
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
		
		
		//Stream<String>을 Stream<Integer>으로 변환
		Stream<Integer> intStream2 = Stream.of(strArr).map(String::length);
		
		
		//Stream<String>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream5 = Stream.of(strArr).mapToInt(String::length);
		
		
		int count = intStream1.reduce(0,(a,b)->a+1);
		int sum = intStream2.reduce(0, (a,b)->a+b);
		
		
		//아래의 reduce는 초기값없이 accumulator을 넣었는데, intStream3에 값이 없을 수 있기 때문에 
		// 받는 참조변수의 타입을 OptionalInt로 한 것임.
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = IntStream.empty().reduce(Integer::min);
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+max.getAsInt());
		System.out.println("min="+min.orElse(0));
		
		
		
		
		
		
		
	}
}
