package com.study.java.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapAndHashTable {

	public static void main(String[] args) {
		/**
		 * HashTable�� ����ȭ�� ����������, HashMap�� ����ȭ�� �������� �ʴ´�.
		 * �Ϲ������� HashMap�� �� ���� ���.
		 * 
		 * Map�� ���� ������ �������� ������, ������ �����ϰ� ���� ��쿡 LinkedHashMap�� ����ϸ� �ȴ�.
		 * 
		 * TreeMap�� TreeSet�� ���.
		 * */
		
		/**
		 * HashMap�� �ؽ̱������ �����͸� �����ϱ� ������, �����Ͱ� ���Ƶ� �˻��� ������.
		 * 
		 * Hashing�̶�� ���� Ű���� ������ �ؽ��Լ��� ����� ��ġ�� �ε����� ���ϴ� �ؽ��ڵ带 ��ȯ�� �ִµ� �̸� ���Ѵ�.
		 * �ؽ�: �ؽ��Լ��� �̿��ؼ� �����͸� �����ϰ�, �о���� ���� ���Ѵ�.
		 * �ؽ����̺��� �迭�� ��ũ�� ����Ʈ�� ���յ� ���·� ���ټ��� �����ϰ� ������ ������ ������ ������ �ִ�.
		 * */
		
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		System.out.println(map);
		map.put("asdf", "1234");
		System.out.println(map);
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id�� password�� �Է����ּ���.");
			System.out.print("id: ");
			String id = s.nextLine().trim(); //
			
			System.out.print("pssword: ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			if(!(map.get(id)).equals("1234")) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			}else {
				System.out.println("id�� ��й�ȣ�� ��ġ�մϴ�.");
				break;
			}
		}//while
		
		
		HashMap map2 = new HashMap();
		map2.put("���ڹ�", new Integer(90));
		map2.put("���ڹ�", new Integer(70));
		map2.put("���ڹ�", new Integer(60));
		map2.put("���ڹ�", new Integer(100));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("�̸�: "+e.getKey()+",����:"+e.getValue());
		}
		
		set = map.keySet();
		System.out.println("������ ���: "+set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("����: "+total);
		System.out.println("���: "+(float)total/set.size());
		System.out.println("�ְ�����: "+Collections.max(values));
		System.out.println("��������: "+Collections.min(values));
		
		
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		HashMap map4 = new HashMap();
		
		for(int i=0; i<data.length; i++) {
			if(map4.containsKey(data[i])) {
				int value = (int)map.get(data[i]);
				map.put(data[i], value+1);
			}else {
				map.put(data[i], 1);
			}
		}
		
		Iterator it2 = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = (int)entry.getValue();
			System.out.println(entry.getKey()+" : "+value);
		}
		
		
		/**
		 * Collections�� �÷����� ���� �޼���(static)�� ����
		 * -> Objects, Arrays, Collections ��� ����
		 * 
		 * 1. fill(), copy(), sort(), binarySearch()��
		 * */
	}
}
