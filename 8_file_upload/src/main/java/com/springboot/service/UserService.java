package com.springboot.service;

import java.util.List;

import com.springboot.entity.User;

public interface UserService {
	
	void addUser(User user);
	List<User> findAllUser();
}
