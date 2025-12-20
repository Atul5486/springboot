package com.springboot.globalException;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
