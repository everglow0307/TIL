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
		
		//map���� Stream<File>�� Stream<String>���� ��ȯ
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);
		
		//��Ʈ�� �ٽ� ����
		fileStream = Stream.of(fileArr);
		
		
		fileStream.map(File::getName)
			.filter(s->s.indexOf('.')!=-1)
			.peek(s->System.out.printf("filename=%s%n",s))
			.map(s->s.substring(s.indexOf('.')+1))
			.peek(s->System.out.printf("extension=%s%n", s))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);
		
		//flatMap() - ��Ʈ���� ��Ʈ���� ��Ʈ������ ��ȯ
		Stream<String[]> strArrStrm = Stream.of(new String[] {"abc","def","ghi"},new String[] {"ABC","DEF","GHI"});
		
		//�Ϲ� map�� ���� ��Ʈ���� ��Ʈ���� �ǹ���.
//		Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);
		
		//flatMap�� ���� �ϳ��� ��Ʈ������ �ٲ���.
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
		
		//���Խ� ǥ�� " +"�� ������ �ϳ� �̻����� �ǹ�
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		
		//int[] arr = null;
		int[] arr = new int[0];
		System.out.println("arr.length="+arr.length);
		
		//Optional<String> opt = null;	//OK. ������ �ٶ���X
		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.of("e");
		
		System.out.println("opt="+opt.get());
		
		String str = "";
		
		try {
			str = opt.get();
		}catch(Exception e) {
			str = "";
		}
		
		//str = opt.orElse("");	//Optional�� ����� ���� null�̸� ""��ȯ
//		str = opt.orElseGet(()->new String());
//		str = opt.orElseGet(String::new);
		System.out.println("str="+str);
		
		//���� ��Ʈ��
		IntStream.range(1, 10).sequential().forEach(System.out::print);
	
		//���� ��Ʈ��-��Ƽ�����尡 ������ �۾�(������ ������� ����.)
		IntStream.range(1, 10).parallel().forEach(System.out::print);
		//�׷��� ���Ľ�Ʈ���� ��, forEachOrdered�� ���� ������ �����.
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);
		
		
		
	}

}
