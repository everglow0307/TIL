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
		/**참조변수를 collection을 쓰면 아래의 코드에서는 Hashset에서만 가능한 코드가 
		*없음을 알려주기 때문에 유연성이 높아짐.
		*/
		
		/**Iterator을 사용하는 이유는 collection인터페이스를 구현하는  클래스들의
		 * 데이터를 꺼내는 방식을 표준화하기 위해
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
