package com.study.java.collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTable {

	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("driver", "oracle.jdbc.driver.OracleDriver");
		hashtable.put("url", "jdbc:oracle:thin:@localhost:1521:Xe");
		hashtable.put("username", "jisu");
		hashtable.put("password", "jisu");
		
		Set<String> keySet = hashtable.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("key="+key+", value="+hashtable.get(key));
		}
		
	}
}
