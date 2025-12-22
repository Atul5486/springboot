package com.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.UserDto;
import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
public class AppController {
	
	@Autowired
	private Environment env;
	
	UserService userService;
	public AppController(UserService userService) {
		this.userService=userService;
	}
	
	
	@GetMapping("/")
	public String index() {
		return "<h2>This is home page</h2>";
	}
	
	
//	@PostMapping("/addUser")
//	public String addUser(@ModelAttribute UserDto userDto) throws IllegalStateException, IOException {
//		
//		MultipartFile file=userDto.getFilename();
//		
//		String filePath=env.getProperty("upload.path");
//		
//		File uploadPath=new File(filePath);
//		if(!uploadPath.exists()) {
//			uploadPath.mkdir();
//		}
//		
//		String filename=System.currentTimeMillis()+file.getOriginalFilename();
//		File Destination=new File(uploadPath,filename);
//		
//		file.transferTo(Destination);
//		
//		User user=new User();
//		user.setUsername(userDto.getUsername());
//		user.setDescription(userDto.getDescription());
//		user.setFilename(filename);
//		
//		userService.addUser(user);
//		
//		return "File uploaded successfully";
//	}
	
	@PostMapping("/multiple")
	public String multiple(@ModelAttribute UserDto userDto) throws IllegalStateException, IOException {
		MultipartFile files[]=userDto.getFilename();
		String uploadPath=env.getProperty("upload.path");
		File uploadFile=new File(uploadPath);
		if(!uploadFile.exists()) {
			uploadFile.mkdir();
		}
		StringBuilder sb=new StringBuilder();
		for(MultipartFile file:files) {
			String filename=System.currentTimeMillis()+file.getOriginalFilename();
			File destination=new File(uploadFile,filename);
			file.transferTo(destination);
			sb.append(filename+",");
		}
		String path=sb.toString();
		String filenames=path.substring(0,path.length()-1);
		
		User user=new User();
		
		user.setFilename(filenames);
		user.setUsername(userDto.getUsername());
		user.setDescription(userDto.getDescription());
		
		userService.addUser(user);
		return "File uploaded successfully";
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(userService.findAllUser());
	}
}
