package com.study.java.genericTest;

import java.util.ArrayList;

public class GenericTest{
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30");
		
		//���� ���� String�ӿ��� �����Ͻÿ� Integer�� �ٿ�ĳ�����ص� ������ �߻����� �ʴ´�.
		//runtime�ÿ� ClassCastException�� �߻��Ѵ�.
		/**
		 * list.get(2)�� ��ȯŸ���� Object�̱� ������ �����ϴ�ÿ��� ������ �߻����� �ʴ´�. 
		 * */
		Integer i = (Integer)list.get(2);
		
		System.out.println(list);
		
		//������ ���׸����� ����ϸ� �����Ͻÿ� Ÿ��üũ�� �� �� �ְ�, �������� ����ȯ�� ������ �� �ִ�.
	}
}