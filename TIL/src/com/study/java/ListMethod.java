package com.study.java;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.out;

public class ListMethod{
	
	
	public static void main(String[] args) {
		
		//1. List인터페이스를 구현하는 ArrayList
		ArrayList<Integer> list1 = new ArrayList(10);
		
		//ArrayList는 객체만 저장이 가능한데, 기본형을 autoboxing해서 자동 변환
		list1.add(5);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(3));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		
		//ArrayList(Collection c)
		ArrayList<Integer> list2 = new ArrayList(list1.subList(1, 4));
		out.println("list1:"+list1+",list2: "+list2);
		
		//Collection은 인터페이스, Collections는 유틸 클래스
		Collections.sort(list1);
		Collections.sort(list2);
		
		list2.add(8);
		list2.add(2,9);
		out.println(list2);
		
		
		list2.set(2,6);
		out.println(list2);
		
		out.println("list1에서 3의 index: "+list1.indexOf(3));
		
		//remove의 인자는 인덱스로 처리하는 것을 우선처리하기 때문에 실제 값 3을 지우지 않고 인덱스 3을 지운다.
		list1.remove(3);
		out.println("list1: "+list1+", list2: "+list2);
		
		//실제 값 3을 지우고 싶은 경우
		list1.remove(new Integer(3));
		out.println("list1: "+list1+", list2: "+list2);
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):"+list1.retainAll(list2));
		out.println("list1: "+list1+", list2: "+list2);
		
		//list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i= list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		
		
		
		
	}
}