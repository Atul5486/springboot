package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Token;
import com.springboot.entity.User;
import com.springboot.service.MailService;
import com.springboot.service.TokenService;
import com.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {

	private MailService mailService;
	private TokenService tokenService;
	private UserService userService;
	
	public  AppController(MailService mailService,TokenService tokenService,UserService userService) {
		this.mailService=mailService;
		this.tokenService=tokenService;
		this.userService=userService;
	}
	
	@GetMapping("/")
	public String index() {
		return "<h1>Welcome on Index page</h1>";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user,HttpServletRequest request){
		
		User userObj = userService.addUser(user);
		System.out.println("---------> "+userObj);
		String token = tokenService.createVerificationToken(userObj);
		String link = request.getRequestURL().toString().replace("addUser", "verify?token="+token);
		System.out.println(link);
		mailService.sendMail(userObj.getEmail(), "Verification Mail", "Hello "+userObj.getEmail()+",<br> This is verification mail, aand you need to verify yourself by clicking on the link given below : <br><br>"+link);	

	return "Mail Sent Successfully, Please verify";
}

@GetMapping("/verify")
public String verifyByMail(@RequestParam("token") String token) {
	Token vt = tokenService.findByToken(token);
	if(vt==null) {
		return "Invalid User";
	}
	User user = vt.getUser();
	user.setActive(true);
	userService.addUser(user);
	return "Verified Successfully";
}
}
