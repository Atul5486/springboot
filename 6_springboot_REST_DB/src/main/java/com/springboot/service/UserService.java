package com.springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.globalException.UserNotFoundException;
import com.springboot.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User updateUserByPatch(int id,String username) {
		User existing=userRepository.findById(id).orElse(null);
		if(existing!=null) {
			existing.setUsername(username);
			return userRepository.save(existing);
		}
		return null;
	}
	
	public User findUser(int id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
	}
	
	public User updateUser(int id,User user) {
		User existing=userRepository.findById(id).orElse(null);
		if(existing!=null) {
			existing.setEmail(user.getEmail());
			existing.setGender(user.getGender());
			existing.setPassword(user.getPassword());
			existing.setUsername(user.getUsername());
			existing.setHobbies(user.getHobbies());
			return userRepository.save(existing);
		}
		return null;
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public boolean deleteUser(int id) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
