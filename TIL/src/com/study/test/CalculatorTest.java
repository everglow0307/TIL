package com.study.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator cal;
	
	
	/**
	 * Before�ֳ����̼��� ����ؼ� calculator�ν��Ͻ��� �����ϸ� 
	 * ���������� �׽�Ʈ �޼��尡 ����ɶ����� �ν��Ͻ��� �����.
	 * ����, private Calculator cal = new Calculator;�� ������ ���� �޼��尡 ����Ǹ鼭 ���� ������ �� ����� �޶��� �� �ֱ� ������
	 * */
	@Before
	public void setup() {
		cal = new Calculator();
		System.out.println("before");
	}
	
	@Test
	public void add() {
		assertEquals(9, cal.add(3,6));
		System.out.println("add");
	}
	
	@Test
	public void subtract() {
		assertEquals(3, cal.subtract(6, 3));
		System.out.println("subtract");
	}
	
	@After
	public void teardown() {
		System.out.println("teardown");
	}

}
