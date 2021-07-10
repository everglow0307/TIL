package com.study.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator cal;
	
	
	/**
	 * Before애너테이션을 사용해서 calculator인스턴스를 생성하면 
	 * 독립적으로 테스트 메서드가 실행될때마다 인스턴스가 실행됨.
	 * 만약, private Calculator cal = new Calculator;로 했으면 여러 메서드가 실행되면서 값에 영향을 줘 결과가 달라질 수 있기 때문에
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
