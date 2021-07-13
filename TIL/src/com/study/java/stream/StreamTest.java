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
		 * �⺻����
		 * strStream.sorted()
		 * strStream.sorted(Comparator.naturalOrder())
		 * strStream.sorted(s1,s2->s1.compareTo(s2))
		 * strStream.sorted(String::compareTo)
		 * 
		 * ����
		 * strStream.sorted(Comparator.reverseOrder())
		 * 
		 * ��ҹ��� ���о���
		 * strStream.sorted(String.CASE_INSENSITIVE_ORDER)
		 * 
		 * */
		
		/** ��Ʈ���� �߰�����
		 * Comparator�� comparing()���� ���� ������ ����
		 * studentStream.sorted(Comparator.comparing(Student::getBan)).forEach(System.out::println)
		 * 
		 * sorted()�� Comparator�� �Ű������� ����.
		 * 
		 * */
		
		Stream<Student> studentStream = Stream.of(
				new Student("���ڹ�",3,300),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",2,100),
				new Student("���ڹ�",1,200),
				new Student("���ڹ�",3,150),
				new Student("���ڹ�",2,200)
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