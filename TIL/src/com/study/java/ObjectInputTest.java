package com.study.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputTest implements Serializable{

	/**
	 * �ڹٿ��� ��ü�� ������ϱ� ���ؼ��� ����Ʈ ������ ��ȯ�ؼ� ��Ʈ���� �̿��ؾ� �ϴµ�
	 * �� ��, ��ü -> ����Ʈ ������ ��ȯ�ϴ� �۾��� ����ȭ��� �ϰ�,
	 * ����Ʈ ���� -> ��ü�� ��ȯ�ϴ� �۾��� ������ȭ��� �Ѵ�.
	 * 
	 * ����ȭ�� �Ǳ� ���ؼ��� Serializable�������̽��� Externalizable�������̽��� �����ؾ� �Ѵ�.
	 * 1. Serializable�������̽����� �޼ҵ尡 ���ǵǾ� ���� �ʰ�, �ش� Ŭ���� ��ü�� ����ȭ������� �ƴ����� �Ǵ��ϴ� ����.
	 * - ����ȭ�ϱ� ���ؼ��� Serializable�������̽��� �����ؾ� �ϰ�, �������� ������ NotSerializableException�߻�.
	 * - �� �������̽��� �����ϸ� Ŭ���� ���� ��� �������� ����ȭ ����� �Ǵµ�, �����ϰ� ���� ��� ���� �տ� transient���� �����Ѵ�.
	 * 
	 * 2. Externalizable�������̽��� serializable�� �ڽ��������̽��̰�, readExternal, writeExternal�޼ҵ带 �����ϰ� �ִ�.
	 *  readExternal�޼ҵ�� writeExternal�޼ҵ忡�� ������ �����鸸 ����ȭ ����� �ȴ�. 
	 * */
	
	/**
	 * ObjectInputStream�� ��ü�� �о�� ��, ������ȭ�� ���ִ� ��� ����.
	 * ObjectOutputStream�� ��ü�� ����� ��, ����ȭ�� ���ִ� ��� ����.
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
		ObjectInputTest before = new ObjectInputTest("aaa", "aaa", "û�ĵ�", 27);
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
