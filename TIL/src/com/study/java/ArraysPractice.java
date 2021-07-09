package com.study.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysPractice {

	public static void main(String[] args) {
		// �迭�� �ٷ� ���� static �޼���
		
		//1.toString()
		
		//2. Arrays.copyOf()
		int[] arr= {0,1,2,3,4};
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOfRange(arr, 2, 4);
		
		//3. ä��� fill(), setAll()
		int[] arr4= new int[5];
		int[] arr5= new int[5];
		Arrays.fill(arr4, 9);
		Arrays.setAll(arr5, (i) -> (int)(Math.random()*5)+1);
		
		
		//4. �迭 ���İ� �˻�
		int[] arr6 = {3,2,0,1,4};
		
		// binarySearch�� ���ĵ� �迭�϶��� �ε����� �ٸ��� ã����.
		int idx = Arrays.binarySearch(arr6, 2);
		
		Arrays.sort(arr6);
		System.out.println(Arrays.toString(arr6));
		idx = Arrays.binarySearch(arr6, 2);
		
		// �������迭 ��� : deepToString()
		int[][] arr20 = {{1,2}, {3,4}};
		int[][] arr21 = {{1,2}, {3,4}};
		
		
		System.out.println(Arrays.deepToString(arr20));
		
		// ������ �迭 �� : deepEquals()
		System.out.println(Arrays.deepEquals(arr20, arr21));
		
		
		// �迭�� ����Ʈ�� ��ȯ : asList(Object... a) ���� �Ű�����
		List list9 = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list10 = Arrays.asList(1,2,3,5,6);
		list10.add(5); //UnsupportedOperationException ���� �߻�
		
		//���� List�� �б������̱� ������ add �޼��� ��� �� ������ �߻�
		// add�� ����ϱ� ���ؼ��� �����ڷ� ��������.
		List list11 = new ArrayList(Arrays.asList(1,2,3,4,5));
		
		/**
		 * ��ü ���Ŀ� �ʿ��� �޼���(���ı��� ����)�� ������ �������̽�
		 * Comparable : �⺻ ���ı��� ����
		 * Comparator : �⺻ ���� �ܿ� �ٸ� �������� ����
		 * 
		 * - compare(Object o1, Object o2): o1, o2 �� ��ü�� ��
		 * - compareTo(Object o) : �־��� ��ü�� �ڽŰ� ��
		 * 
		 * �������� ũ�� ����, ������ ���, ������ 0�� ��ȯ
		 * */
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //��ҹ��� ���о��ϰ� ����
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
		
	}
}

class Descending implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		if(arg0 instanceof Comparable && arg1 instanceof Comparable) {
			Comparable c1 = (Comparable)arg0;
			Comparable c2 = (Comparable)arg1;
			return c1.compareTo(c2) * -1; //��������
		}
		return -1;
	}
	
}