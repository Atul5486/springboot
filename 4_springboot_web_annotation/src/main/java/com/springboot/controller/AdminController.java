package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController{
	
	@GetMapping("/")
	public String admin() {
		return "<h2>This is admin</h2>";
	}
	
	@GetMapping("/details")
	public String userDetails() {
		return "<h2>This is admin details</h2>";
	}
	
}