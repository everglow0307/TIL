package com.study.java.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAndCollectorsTest {

	public static void main(String[] args) {
		
		/**
		 * 최종연산
		 * 
		 * reduce: 스트림의 전체에 대해서 리듀싱.
		 * collect(): 그룹별 리듀싱
		 * 
		 * 
		 * collect()는 Collector를 매개변수로 하는 스트림의 최종연산
		 * Collector는 수집에 필요한 메서드를 정의해 놓은 인터페이스
		 * 
		 * Collectors클래스는 다양한 기능의 컬렉터(Collector를 구현한 클래스)를 제공
		 * -고로 얘만, 잘 쓰면 됨.
		 * */
		
		/**
		 * partitioningBy()는 스트림을 2분할.
		 * groupingBy()은 스트림을 n분할.
		 * */
		
		Student2[] stuArr = {
				new Student2("김자바",true,1,2,300),
				new Student2("나자바",false,2,1,250),
				new Student2("다자바",true,1,1,300),
				new Student2("라자바",false,2,1,100),
				new Student2("마자바",true,3,3,50),
				new Student2("바자바",false,1,1,300),
				new Student2("사자바",true,1,2,700),
				new Student2("아자바",false,1,1,300),
				new Student2("자자바",false,2,7,300),
				new Student2("마자바",true,1,1,200),
				new Student2("카자바",true,3,1,300),
				new Student2("파자바",true,2,3,250),
				new Student2("하자바",true,1,5,150),
				new Student2("차자바",true,1,1,300),
		};
	
		System.out.println("1. 단순분할(성별로 분할)%n");
		Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student2::isFemale));
		
		List<Student2> femaleStudent = stuBySex.get(true);
		List<Student2> maleStudent = stuBySex.get(false);
		
		for(Student2 s: maleStudent) System.out.println(s);
		for(Student2 s: femaleStudent) System.out.println(s);
		
		System.out.println("%n2.단순분할+통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student2::isFemale, Collectors.counting()));

		System.out.println("남학생 수: "+stuNumBySex.get(false));
		System.out.println("여학생 수: "+stuNumBySex.get(true));
		
		
		// groupingBy() 
		System.out.println("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student2::getBan));
		
		for(List<Student2> ban: stuByBan.values()) {
			for(Student2 s :ban) {
				System.out.println(s);
			}
		}
		
		System.out.println("%n2. 단순그룹화(성적별로 그룹화)%n");
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
		return String.format("[%s,%s,%d학년%d반, %3d점]", name, isFemale?"여":"남",hak,ban,score);
	}
	
	//groupingBy()에서 사용
	enum Level {HIGH, MID, LOW}
	
	
}
