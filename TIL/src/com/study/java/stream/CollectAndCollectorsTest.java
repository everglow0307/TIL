package com.study.java.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAndCollectorsTest {

	public static void main(String[] args) {
		
		/**
		 * ��������
		 * 
		 * reduce: ��Ʈ���� ��ü�� ���ؼ� �����.
		 * collect(): �׷캰 �����
		 * 
		 * 
		 * collect()�� Collector�� �Ű������� �ϴ� ��Ʈ���� ��������
		 * Collector�� ������ �ʿ��� �޼��带 ������ ���� �������̽�
		 * 
		 * CollectorsŬ������ �پ��� ����� �÷���(Collector�� ������ Ŭ����)�� ����
		 * -��� �길, �� ���� ��.
		 * */
		
		/**
		 * partitioningBy()�� ��Ʈ���� 2����.
		 * groupingBy()�� ��Ʈ���� n����.
		 * */
		
		Student2[] stuArr = {
				new Student2("���ڹ�",true,1,2,300),
				new Student2("���ڹ�",false,2,1,250),
				new Student2("���ڹ�",true,1,1,300),
				new Student2("���ڹ�",false,2,1,100),
				new Student2("���ڹ�",true,3,3,50),
				new Student2("���ڹ�",false,1,1,300),
				new Student2("���ڹ�",true,1,2,700),
				new Student2("���ڹ�",false,1,1,300),
				new Student2("���ڹ�",false,2,7,300),
				new Student2("���ڹ�",true,1,1,200),
				new Student2("ī�ڹ�",true,3,1,300),
				new Student2("���ڹ�",true,2,3,250),
				new Student2("���ڹ�",true,1,5,150),
				new Student2("���ڹ�",true,1,1,300),
		};
	
		System.out.println("1. �ܼ�����(������ ����)%n");
		Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student2::isFemale));
		
		List<Student2> femaleStudent = stuBySex.get(true);
		List<Student2> maleStudent = stuBySex.get(false);
		
		for(Student2 s: maleStudent) System.out.println(s);
		for(Student2 s: femaleStudent) System.out.println(s);
		
		System.out.println("%n2.�ܼ�����+���(���� �л���)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student2::isFemale, Collectors.counting()));

		System.out.println("���л� ��: "+stuNumBySex.get(false));
		System.out.println("���л� ��: "+stuNumBySex.get(true));
		
		
		// groupingBy() 
		System.out.println("1. �ܼ��׷�ȭ(�ݺ��� �׷�ȭ)%n");
		Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student2::getBan));
		
		for(List<Student2> ban: stuByBan.values()) {
			for(Student2 s :ban) {
				System.out.println(s);
			}
		}
		
		System.out.println("%n2. �ܼ��׷�ȭ(�������� �׷�ȭ)%n");
		Map<Student2.Level, List<Student2>> stuByLevel = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore() >= 200) return Student2.Level.HIGH;
					else if(s.getScore() >= 100) return Student2.Level.MID;
					else 						return Student2.Level.LOW;
				}));
		
	}
}

class Student2 {
	String name;
	boolean isFemale;
	int hak;
	int ban;
	int score;
	
	Student2(String name, boolean isFemale, int hak, int ban, int score){
		this.name = name;
		this.isFemale = isFemale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}
	
	String getName() {return name;}
	boolean isFemale() {return isFemale;}
	int getHak() {return hak;}
	int getBan() {return ban;}
	int getScore() {return score;}
	
	public String toString() {
		return String.format("[%s,%s,%d�г�%d��, %3d��]", name, isFemale?"��":"��",hak,ban,score);
	}
	
	//groupingBy()���� ���
	enum Level {HIGH, MID, LOW}
	
	
}
