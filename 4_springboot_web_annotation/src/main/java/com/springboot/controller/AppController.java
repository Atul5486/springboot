package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;

import jakarta.websocket.server.PathParam;

@RestController // RestController=Controller+Request Body

public class AppController{
	
	@GetMapping("/")
	public String index() {
		return "<h1>This is main page</h1>";
	}
	
	@GetMapping("/about")
	public String about() {
		return "<h1>This is about</h1>";
	}
	
	@GetMapping("/addUser")
	public User addUser() {
		return new User(101,"ajay","ajay@gmail.com","1234");
	}
	
	@GetMapping("/user/{id}")
	public String user(@PathVariable int id) {
		return "This is "+id;
	}
	
	@GetMapping("/getDetails")
	public String getDetails(@RequestParam String username,@RequestParam String email){return "<h2>Email"+email+"User Name : "+username+"</h2>";
	}	
}