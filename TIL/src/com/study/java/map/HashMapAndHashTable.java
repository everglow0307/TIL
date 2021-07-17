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
		 * HashTable은 동기화를 제공하지만, HashMap은 동기화를 제공하지 않는다.
		 * 일반적으로 HashMap을 더 많이 사용.
		 * 
		 * Map은 원래 순서를 유지하지 않지만, 순서를 유지하고 싶은 경우에 LinkedHashMap을 사용하면 된다.
		 * 
		 * TreeMap은 TreeSet과 비슷.
		 * */
		
		/**
		 * HashMap은 해싱기법으로 데이터를 저장하기 때문에, 데이터가 많아도 검색이 빠르다.
		 * 
		 * Hashing이라는 것은 키값을 넣으면 해시함수로 저장된 위치인 인덱스를 뜻하는 해쉬코드를 반환해 주는데 이를 말한다.
		 * 해싱: 해쉬함수를 이용해서 데이터를 저장하고, 읽어오는 것을 말한다.
		 * 해쉬테이블은 배열과 링크드 리스트가 조합된 형태로 접근성이 유리하고 변경이 유리한 장점을 가지고 있다.
		 * */
		
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		System.out.println(map);
		map.put("asdf", "1234");
		System.out.println(map);
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id: ");
			String id = s.nextLine().trim(); //
			
			System.out.print("pssword: ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			
			if(!(map.get(id)).equals("1234")) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
		}//while
		
		
		HashMap map2 = new HashMap();
		map2.put("김자바", new Integer(90));
		map2.put("강자바", new Integer(70));
		map2.put("이자바", new Integer(60));
		map2.put("정자바", new Integer(100));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름: "+e.getKey()+",점수:"+e.getValue());
		}
		
		set = map.keySet();
		System.out.println("참가자 명단: "+set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("총점: "+total);
		System.out.println("평균: "+(float)total/set.size());
		System.out.println("최고점수: "+Collections.max(values));
		System.out.println("최저점수: "+Collections.min(values));
		
		
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
		 * Collections는 컬렉션을 위한 메서드(static)를 제공
		 * -> Objects, Arrays, Collections 모두 동일
		 * 
		 * 1. fill(), copy(), sort(), binarySearch()등
		 * */
	}
}
