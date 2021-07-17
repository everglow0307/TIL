package com.study.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.study.java.onion.StringCalculator;

public class StringCalculatorTest2 {

	/**
	 * 리팩토링 원칙1. 메서드하나는 하나의 기능만 담당할 것.
	 * 원칙2. 들여쓰기 잘 할 것.
	 * */
	private StringCalculator cal;
	
	@Before
	public void setUp() {
		this.cal = new StringCalculator();
	}
	
	@Test
	public void add_null_또는_빈문자() {
		assertEquals(0,cal.add(null));
		assertEquals(0,cal.add(""));
	}
	
	@Test
	public void add_숫자하나() throws Exception {
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void add_쉼표구분자() throws Exception{
		assertEquals(3,cal.add("1,2"));
	}
	
	@Test
	public void add_쉼표_또는_콜론_구분자() throws Exception{
		assertEquals(6,cal.add("1,2:3"));
	}
	
	@Test
	public void add_custom_구분자() throws Exception{
		assertEquals(6,cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_negative() throws Exception{
		cal.add("-1,2,3");
	}
	
}
