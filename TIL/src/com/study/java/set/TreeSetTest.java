package com.study.java.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		/**
		 * TreeSet�� ����Ž��Ʈ���� ����. ���� Ž���� ���Ŀ� �����ϴ�.
		 * ���� Ʈ���� ��� ��尡 �ִ� 2���� ���� ��带 ������.
		 * */
		
		/**
		 * ���� Ž��Ʈ��(binary search tree)
		 * : �θ𺸴� ���� ���� ����, ū ���� �����ʿ� ����
		 * -> ����Ʈ���� �� ����
		 * - �����Ͱ� ������ ���� �߰�, ������ �ð��� �� �ɸ�(�� Ƚ�� ����)
		 * */
		
		/**
		 * Treeset�� add�Ҷ� ���ϸ鼭 ����Ǳ� ������ �񱳱����� Comparator�� �����ؼ� �����ڷ� ��ü�� ������ �Ѵ�.
		 * �� ���� ��� comparable�⺻���ķ� ������.
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

//�� ������ ����.
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
