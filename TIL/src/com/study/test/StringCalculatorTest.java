package com.study.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.study.java.onion.StringCalculator;

public class StringCalculatorTest {

	private StringCalculator scal;
	
	@Before
	public void setUp() {
		this.scal = new StringCalculator();
	}
	
	@Test
	public void checkBasicSplit() {
		assertEquals(6,scal.calculator("1,2:3"));
	} 
	
	@Test
	public void checkCustomSplit() {
		assertEquals(9, scal.calculator("//;\n4;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void checkUmsu() {
		scal.calculator("-3:2:1");
	}
	
	//JUnit 4.7부터 Rule사용가능(예상되는 예외의 메세지까지 확인해야 하는 경우)
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void checkUmsu2() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("customized Exception");
		scal.calculator("-4:5:-2");
		
	}
	
}
