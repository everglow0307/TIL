package com.study.java.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		/**
		 * HashSet: Set인터페이스를 구현한 대표적 컬렉션 클래스
		 * 순서를 유지하려면 LinkedHashSet클래스를 사용하면 된다.
		 * 
		 * Treeset은 범위 검색과 정렬에 유리한 컬렉션 클래스
		 * hashset보다 데이터 추가 ,삭제에 시간이 더 걸림.
		 * */
		//Object[] objArr = {"1",new Integer(1), "2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
//		for(int i=0;i<objArr.length;i++) {
//			set.add(objArr[i]);
//		}
		
		for(int i=0;set.size() < 6;i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		
		System.out.println(set);

		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
		
		//set은 순서가 보장이 되지 않아서 정렬을 할 수가 없다.
		/**
		 * 만약, 정렬하고 싶으면 LinkedList를 set을 넣어서 만들어서 정렬해야 한다.
		 * */
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
		
		/* HashSet에 객체를 저장할때, 중복된 필드값을 가진 객체를 여러번 저장해도
		** 저장이 된다. 왜냐하면 HashSet은 equals와 hashcode를 통해 비교를 하는데
		* 이들을 오버라이딩 하지 않으면, 중복된 객체라고 인식하지 않기 때문이다.
		*/
		HashSet set2 = new HashSet();
		
		set2.add("abc");
		set2.add("abc");
		set2.add(new Person("David",20));
		set2.add(new Person("David",20));
		
		System.out.println(set2);
		
		
		//================================================
		
		HashSet<String> setA = new HashSet();
		HashSet<String> setB = new HashSet();
		
		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		setA.add("6");
		
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		
		
		//교집합
		setA.retainAll(setB);
		System.out.println(setA);
		
		//합집합
//		setA.addAll(setB);
//		System.out.println(setA);
		
		//차집합
//		setA.removeAll(setB);
//		System.out.println(setA);
		
	}

}

//equals()와 hashcode()를 오버라이딩 해야 함.
class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name+":"+age;
	}

	@Override
	public int hashCode() {
		// int hash(Object... values); //가변인자
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		
		Person p = (Person)obj;
		
		return this.name.equals(p.name)&&this.age==p.age;
	}
	
	/**
	 * HashCode()는 객체의 해시코드를 반환하는 메서드
	 * Object클랫의 hashcode는 객체의 주소를 int로 변환해서 반환
	 * equals()를 오버라이딩하면 hashcode도 오버라이딩해야 합니다.
	 * equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문.
	 * */
	
}
