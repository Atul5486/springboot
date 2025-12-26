package com.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest{
	
	@Autowired
	private JWTService jwtService;
	
	@Test
	public void testAdd() {
		assertEquals(4, 1+2);
	}
	@Test
	public void testGenerateEquals() {
		assertNotEquals("", jwtService.generateToken("peter"));
	}
	@Test
	public void testGenerateNotNull() {
		assertNotNull(jwtService.generateToken("peter"));
	}
}