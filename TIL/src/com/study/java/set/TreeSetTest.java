package com.study.java.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		/**
		 * TreeSet은 이진탐색트리로 구현. 범위 탐색과 정렬에 유리하다.
		 * 이진 트리는 모든 노드가 최대 2개의 하위 노드를 가진다.
		 * */
		
		/**
		 * 이진 탐색트리(binary search tree)
		 * : 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장
		 * -> 이진트리의 한 종류
		 * - 데이터가 많아질 수록 추가, 삭제에 시간이 더 걸림(비교 횟수 증가)
		 * */
		
		/**
		 * Treeset은 add할때 비교하면서 저장되기 때문에 비교기준인 Comparator를 제공해서 생성자로 객체를 만들어야 한다.
		 * 안 넣을 경우 comparable기본정렬로 생성됨.
		 * */
		Set set = new TreeSet(new TestComp());
		
//		for(int i=0;set.size()<6;i++) {
//			int num = (int)(Math.random()*45)+1;
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
//			//set.add(new Integer(num));
//		}
		
		System.out.println(set);
		
		TreeSet set2 = new TreeSet();
		
		set2.add("apple");
		set2.add("banana");
		set2.add("couch");
		set2.add("diamond");
		set2.add("double");
		set2.add("even");
		
		System.out.println(set2.subSet("a", "c"));
		
		TreeSet set3 = new TreeSet();
		int[] score = {80, 90,95,50,65,45,100};
		
		for(int i=0;i<score.length;i++) {
			set3.add(score[i]);
		}
		
		System.out.println(set3.headSet(50));
		System.out.println(set3.tailSet(50));
		
		
	}

}

//비교 기준이 없음.
class Test implements Comparable {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1;
	}
	
}

class TestComp implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return -1;
	}
	
}
