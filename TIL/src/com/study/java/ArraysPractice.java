package com.study.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysPractice {

	public static void main(String[] args) {
		// 배열을 다룰 때의 static 메서드
		
		//1.toString()
		
		//2. Arrays.copyOf()
		int[] arr= {0,1,2,3,4};
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOfRange(arr, 2, 4);
		
		//3. 채우기 fill(), setAll()
		int[] arr4= new int[5];
		int[] arr5= new int[5];
		Arrays.fill(arr4, 9);
		Arrays.setAll(arr5, (i) -> (int)(Math.random()*5)+1);
		
		
		//4. 배열 정렬과 검색
		int[] arr6 = {3,2,0,1,4};
		
		// binarySearch는 정렬된 배열일때만 인덱스를 바르게 찾아줌.
		int idx = Arrays.binarySearch(arr6, 2);
		
		Arrays.sort(arr6);
		System.out.println(Arrays.toString(arr6));
		idx = Arrays.binarySearch(arr6, 2);
		
		// 다차원배열 출력 : deepToString()
		int[][] arr20 = {{1,2}, {3,4}};
		int[][] arr21 = {{1,2}, {3,4}};
		
		
		System.out.println(Arrays.deepToString(arr20));
		
		// 다차원 배열 비교 : deepEquals()
		System.out.println(Arrays.deepEquals(arr20, arr21));
		
		
		// 배열을 리스트로 변환 : asList(Object... a) 가변 매개변수
		List list9 = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list10 = Arrays.asList(1,2,3,5,6);
		list10.add(5); //UnsupportedOperationException 예외 발생
		
		//위의 List는 읽기전용이기 때문에 add 메서드 사용 시 오류가 발생
		// add를 사용하기 위해서는 생성자로 만들어야함.
		List list11 = new ArrayList(Arrays.asList(1,2,3,4,5));
		
		/**
		 * 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스
		 * Comparable : 기본 정렬기준 구현
		 * Comparator : 기본 기준 외에 다른 기준으로 정렬
		 * 
		 * - compare(Object o1, Object o2): o1, o2 두 객체를 비교
		 * - compareTo(Object o) : 주어진 객체를 자신과 비교
		 * 
		 * 오른쪽이 크면 음수, 작으면 양수, 같으면 0을 반환
		 * */
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안하고 정렬
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
			return c1.compareTo(c2) * -1; //역순정렬
		}
		return -1;
	}
	
}