package com.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomeExceptionHandler {

	@ExceptionHandler(JwtException.class)
	public ResponseEntity<Map<String,String>> handleException(JwtException e){
		Map<String, String> result=new HashMap<String, String>();
		result.put("status", "403");
		result.put("message", "forbidden");
		result.put("exception", e.getMessage());
		return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
	}
	
}
