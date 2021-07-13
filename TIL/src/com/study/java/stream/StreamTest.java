package com.study.java.stream;

import java.io.File;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest{
	public static void main(String[] args) {
		
		Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));
//		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println);
		
		fileStream.map(File::getName)
			.filter(s->s.indexOf('.')!=-1)
			.map(s->s.substring(s.indexOf('.')+1))
			.map(String::toUpperCase)
			.distinct()
			.forEach(System.out::println);
		
		IntStream intStream = IntStream.rangeClosed(1, 10);
		intStream.skip(3).limit(5).forEach(System.out::println);
		
		//filter
		IntStream intStream2 = IntStream.rangeClosed(1, 10);
		intStream2.filter(i->i%2==0).forEach(System.out::print);
		
		//sorted
		/**
		 * 기본정렬
		 * strStream.sorted()
		 * strStream.sorted(Comparator.naturalOrder())
		 * strStream.sorted(s1,s2->s1.compareTo(s2))
		 * strStream.sorted(String::compareTo)
		 * 
		 * 역순
		 * strStream.sorted(Comparator.reverseOrder())
		 * 
		 * 대소문자 구분안함
		 * strStream.sorted(String.CASE_INSENSITIVE_ORDER)
		 * 
		 * */
		
		/** 스트림의 중간연산
		 * Comparator의 comparing()으로 정렬 기준을 제공
		 * studentStream.sorted(Comparator.comparing(Student::getBan)).forEach(System.out::println)
		 * 
		 * sorted()는 Comparator을 매개변수로 받음.
		 * 
		 * */
		
		Stream<Student> studentStream = Stream.of(
				new Student("정자바",3,300),
				new Student("김자바",1,200),
				new Student("최자바",2,100),
				new Student("박자바",1,200),
				new Student("나자바",3,150),
				new Student("소자바",2,200)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan).reversed()
			.thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
	}
}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String toString() {
		return String.format("[%s, %d, %d]",name, ban, totalScore);
	}
	
	String getName() {return name;}
	int getBan() {return ban;}
	int getTotalScore() {return totalScore;}
	
	
	@Override
	public int compareTo(Student s) {
		return s.totalScore-this.totalScore;
	}
	
}