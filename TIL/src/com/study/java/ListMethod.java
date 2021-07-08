package com.study.java;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.out;

public class ListMethod{
	
	
	public static void main(String[] args) {
		
		//1. List�������̽��� �����ϴ� ArrayList
		ArrayList<Integer> list1 = new ArrayList(10);
		
		//ArrayList�� ��ü�� ������ �����ѵ�, �⺻���� autoboxing�ؼ� �ڵ� ��ȯ
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
		
		//Collection�� �������̽�, Collections�� ��ƿ Ŭ����
		Collections.sort(list1);
		Collections.sort(list2);
		
		list2.add(8);
		list2.add(2,9);
		out.println(list2);
		
		
		list2.set(2,6);
		out.println(list2);
		
		out.println("list1���� 3�� index: "+list1.indexOf(3));
		
		//remove�� ���ڴ� �ε����� ó���ϴ� ���� �켱ó���ϱ� ������ ���� �� 3�� ������ �ʰ� �ε��� 3�� �����.
		list1.remove(3);
		out.println("list1: "+list1+", list2: "+list2);
		
		//���� �� 3�� ����� ���� ���
		list1.remove(new Integer(3));
		out.println("list1: "+list1+", list2: "+list2);
		
		//list1���� list2�� ��ġ�� �κи� ����� �������� �����Ѵ�.
		System.out.println("list1.retainAll(list2):"+list1.retainAll(list2));
		out.println("list1: "+list1+", list2: "+list2);
		
		//list2���� list1�� ���Ե� ��ü���� �����Ѵ�.
		for(int i= list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		
		
		
		
	}
}