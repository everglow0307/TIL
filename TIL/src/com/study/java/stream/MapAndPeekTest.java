package com.study.java.stream;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndPeekTest {
	
	public static void main(String[] args) {
		
		//peek
		File[] fileArr = {new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt")};

		Stream<File> fileStream = Stream.of(fileArr);
		
		//map으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);
		
		//스트림 다시 생성
		fileStream = Stream.of(fileArr);
		
		
		fileStream.map(File::getName)
			.filter(s->s.indexOf('.')!=-1)
			.peek(s->System.out.printf("filename=%s%n",s))
			.map(s->s.substring(s.indexOf('.')+1))
			.peek(s->System.out.printf("extension=%s%n", s))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);
		
		//flatMap() - 스트림의 스트림을 스트림으로 변환
		Stream<String[]> strArrStrm = Stream.of(new String[] {"abc","def","ghi"},new String[] {"ABC","DEF","GHI"});
		
		//일반 map을 쓰면 스트림의 스트림이 되버림.
//		Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);
		
		//flatMap을 쓰면 하나의 스트림으로 바꿔짐.
		Stream<String> strStrStrm2 = strArrStrm.flatMap(Arrays::stream);
		
		strStrStrm2.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Hellow, My World!!",
				"I'll be there",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		
		//정규식 표현 " +"은 공백이 하나 이상임을 의미
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		
		//int[] arr = null;
		int[] arr = new int[0];
		System.out.println("arr.length="+arr.length);
		
		//Optional<String> opt = null;	//OK. 하지만 바람직X
		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.of("e");
		
		System.out.println("opt="+opt.get());
		
		String str = "";
		
		try {
			str = opt.get();
		}catch(Exception e) {
			str = "";
		}
		
		//str = opt.orElse("");	//Optional에 저장된 값이 null이면 ""반환
//		str = opt.orElseGet(()->new String());
//		str = opt.orElseGet(String::new);
		System.out.println("str="+str);
		
		//직렬 스트림
		IntStream.range(1, 10).sequential().forEach(System.out::print);
	
		//병렬 스트림-멀티쓰레드가 나눠서 작업(순서가 보장되지 않음.)
		IntStream.range(1, 10).parallel().forEach(System.out::print);
		//그러나 병렬스트림일 때, forEachOrdered를 쓰면 순서가 보장됨.
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);
		
		
		
	}

}
