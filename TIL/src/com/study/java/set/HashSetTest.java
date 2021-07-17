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
		 * HashSet: Set�������̽��� ������ ��ǥ�� �÷��� Ŭ����
		 * ������ �����Ϸ��� LinkedHashSetŬ������ ����ϸ� �ȴ�.
		 * 
		 * Treeset�� ���� �˻��� ���Ŀ� ������ �÷��� Ŭ����
		 * hashset���� ������ �߰� ,������ �ð��� �� �ɸ�.
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
	
		
		//set�� ������ ������ ���� �ʾƼ� ������ �� ���� ����.
		/**
		 * ����, �����ϰ� ������ LinkedList�� set�� �־ ���� �����ؾ� �Ѵ�.
		 * */
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
		
		/* HashSet�� ��ü�� �����Ҷ�, �ߺ��� �ʵ尪�� ���� ��ü�� ������ �����ص�
		** ������ �ȴ�. �ֳ��ϸ� HashSet�� equals�� hashcode�� ���� �񱳸� �ϴµ�
		* �̵��� �������̵� ���� ������, �ߺ��� ��ü��� �ν����� �ʱ� �����̴�.
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
		
		
		//������
		setA.retainAll(setB);
		System.out.println(setA);
		
		//������
//		setA.addAll(setB);
//		System.out.println(setA);
		
		//������
//		setA.removeAll(setB);
//		System.out.println(setA);
		
	}

}

//equals()�� hashcode()�� �������̵� �ؾ� ��.
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
		// int hash(Object... values); //��������
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		
		Person p = (Person)obj;
		
		return this.name.equals(p.name)&&this.age==p.age;
	}
	
	/**
	 * HashCode()�� ��ü�� �ؽ��ڵ带 ��ȯ�ϴ� �޼���
	 * ObjectŬ���� hashcode�� ��ü�� �ּҸ� int�� ��ȯ�ؼ� ��ȯ
	 * equals()�� �������̵��ϸ� hashcode�� �������̵��ؾ� �մϴ�.
	 * equals()�� ����� true�� �� ��ü�� �ؽ��ڵ�� ���ƾ� �ϱ� ����.
	 * 
	 * 
	 * */
}
