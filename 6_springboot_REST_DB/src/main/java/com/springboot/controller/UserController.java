package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.globalException.UserNotFoundException;
import com.springboot.service.UserService;

@RestController
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}

	@GetMapping("/")
	public String index() {
		return "<h1>This is index and home page</h1>";
	}
	
	@GetMapping("/usersList")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(id));
	}
	
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(id, user));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id,@RequestBody User user){
		if(userService.deleteUser(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("User Deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not deleted");
	}
	
	@PatchMapping("/updateUserByPatch/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody String username){
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserByPatch(id,username ));
	}
	
	
	
	
	
}
