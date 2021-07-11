package com.study.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputTest implements Serializable{

	/**
	 * 자바에서 객체를 입출력하기 위해서는 바이트 단위로 변환해서 스트림을 이용해야 하는데
	 * 이 때, 객체 -> 바이트 단위로 변환하는 작업을 직렬화라고 하고,
	 * 바이트 단위 -> 객체로 변환하는 작업을 역직렬화라고 한다.
	 * 
	 * 직렬화가 되기 위해서는 Serializable인터페이스나 Externalizable인터페이스를 구현해야 한다.
	 * 1. Serializable인터페이스에는 메소드가 정의되어 있지 않고, 해당 클래스 객체가 직렬화대상인지 아닌지를 판단하는 역할.
	 * - 직렬화하기 위해서는 Serializable인터페이스를 구현해야 하고, 구현하지 않으면 NotSerializableException발생.
	 * - 이 인터페이스를 구현하면 클래스 안의 모든 변수들이 직렬화 대상이 되는데, 제외하고 싶은 경우 변수 앞에 transient예약어를 지정한다.
	 * 
	 * 2. Externalizable인터페이스는 serializable의 자식인터페이스이고, readExternal, writeExternal메소드를 정의하고 있다.
	 *  readExternal메소드와 writeExternal메소드에서 정의한 변수들만 직렬화 대상이 된다. 
	 * */
	
	/**
	 * ObjectInputStream은 객체를 읽어올 때, 역질렬화를 해주는 기능 제공.
	 * ObjectOutputStream은 객체를 출력할 때, 직렬화를 해주는 기능 제공.
	 * */

	private String id;
	private String password;
	private String dong;
	private transient int age;
	
	public ObjectInputTest(String id, String password, String dong, int age) {
		this.id = id;
		this.password = password;
		this.dong = dong;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ObjectInputTest [id=" + id + ", password=" + password + ", dong=" + dong + "]";
	}
	
	public static void main(String[] args) {
		ObjectInputTest before = new ObjectInputTest("aaa", "aaa", "청파동", 27);
		ObjectInputTest after = null;
		FileOutputStream fileos = null;
		ObjectOutputStream objectos = null;
		FileInputStream fileis = null;
		ObjectInputStream objectis = null;
		
		try {
			fileos = new FileOutputStream("userInfo.txt");
			objectos = new ObjectOutputStream(fileos);
			objectos.writeObject(before);
			
			fileis = new FileInputStream("userInfo.txt");
			objectis = new ObjectInputStream(fileis);
			after = (ObjectInputTest)objectis.readObject();
			
			System.out.println(after);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fileos.close();
				fileis.close();
				objectos.close();
				objectis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
