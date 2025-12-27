package com.springboot.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;
	private JwtService jwtService;
	
	public AuthController(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder,JwtService jwtService) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtService=jwtService;
	}
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome to Auth Home page</h1>";
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Map<String ,String>> login(@RequestBody User user){
		String email=user.getEmail();
		String password=user.getPassword();
		
		User userObj=userRepository.findByEmail(email);
		
		if(!passwordEncoder.matches(password,userObj.getPassword())) {
			throw new RuntimeException("Credential Mismatch");
		}
		
		String token=jwtService.generateToken(email,userObj.getRole());
		
		return new ResponseEntity<Map<String,String>>(Map.of("token",token),HttpStatus.OK);
	}
	
}
