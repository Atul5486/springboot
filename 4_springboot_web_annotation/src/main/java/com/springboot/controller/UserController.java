package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@GetMapping("/")
	public String user() {
		return "<h2>This is user</h2>";
	}
	
	@GetMapping("/details")
	public String userDetails() {
		return "<h2>This is user details</h2>";
	}
	
	
}