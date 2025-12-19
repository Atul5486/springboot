package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
public class UserController{
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@GetMapping("/")
	@ResponseBody	
	public String home() {
		return "<h2>Welcome to RestAPI NO Database Example</h2>";
	}
	
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}
	@GetMapping("/findUser/{id}")
	public ResponseEntity<User> finduser(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,User user){
		return new ResponseEntity<User>(userService.update(id, user),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		boolean status=userService.delete(id);
		if(status)
			return ResponseEntity.ok("User Deleted successfully");
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}