package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.JWTService;

@RestController
public class JWTController{
	
	@Autowired
	private JWTService jwtService;
	
	@GetMapping("/")
	public String index() {
		return "<h1>This is index page</h1>";
	}
	
	@PostMapping("/generate")
	public String generateToken(@RequestBody String username) {
		return jwtService.generateToken(username);
	}
	@GetMapping("/generate")
	public String generate(@RequestParam String username) {
		return jwtService.generateToken(username);
	}
	
	@GetMapping("/check")
	public String validateToken(@RequestHeader("Authorization") String token) {
		System.out.println(token);
		String tk=token.substring(7);
		System.out.println(tk);
		boolean result=jwtService.validateToken(tk);
		return result ? "<h1>Valid Token</h1>":"<h1>InValid Token</h1>";
	}
	
}