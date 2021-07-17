package com.study.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.study.java.onion.StringCalculator;

public class StringCalculatorTest2 {

	/**
	 * �����丵 ��Ģ1. �޼����ϳ��� �ϳ��� ��ɸ� ����� ��.
	 * ��Ģ2. �鿩���� �� �� ��.
	 * */
	private StringCalculator cal;
	
	@Before
	public void setUp() {
		this.cal = new StringCalculator();
	}
	
	@Test
	public void add_null_�Ǵ�_����() {
		assertEquals(0,cal.add(null));
		assertEquals(0,cal.add(""));
	}
	
	@Test
	public void add_�����ϳ�() throws Exception {
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void add_��ǥ������() throws Exception{
		assertEquals(3,cal.add("1,2"));
	}
	
	@Test
	public void add_��ǥ_�Ǵ�_�ݷ�_������() throws Exception{
		assertEquals(6,cal.add("1,2:3"));
	}
	
	@Test
	public void add_custom_������() throws Exception{
		assertEquals(6,cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_negative() throws Exception{
		cal.add("-1,2,3");
	}
	
}
