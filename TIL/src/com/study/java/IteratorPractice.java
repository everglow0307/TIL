package com.study.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorPractice {

	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList();
//		HashSet list = new HashSet();
		Collection c = new HashSet();
		/**���������� collection�� ���� �Ʒ��� �ڵ忡���� Hashset������ ������ �ڵ尡 
		*������ �˷��ֱ� ������ �������� ������.
		*/
		
		/**Iterator�� ����ϴ� ������ collection�������̽��� �����ϴ�  Ŭ��������
		 * �����͸� ������ ����� ǥ��ȭ�ϱ� ����
		 */
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		c.add("5");
		
		Iterator it = c.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		
	}
	
	
}
