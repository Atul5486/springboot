package com.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ParameterizedTestExample{
	
	
	@ParameterizedTest
	@CsvSource({
		"1,1,2",
		"10,2,12"
	})
	public void simpleTest(int a,int b,int excepted) {
		assertEquals(excepted, a+b);
	}
	
	@ParameterizedTest 
	@ValueSource(ints={
		10,20,30
	})
	public void simpleTest1(int a) {
		assertEquals(a,10);
	}
}