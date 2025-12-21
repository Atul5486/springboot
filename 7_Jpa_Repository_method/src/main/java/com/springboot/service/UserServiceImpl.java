package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findUserByAddress(String address) {
		return userRepository.findByAddress(address);
	}

	@Override
	public List<User> findUserByHobbies(String hobby) {
		return userRepository.findByHobbies(hobby);
	}

	@Override
	public List<User> findUserByGenderAndAddress(String gender, String address) {
		return userRepository.findByGenderAndAddress(gender, address);
	}

	@Override
	public List<User> findUserByGenderOrAddress(String gender, String address) {
		return userRepository.findByGenderOrAddress(gender, address);
	}

	@Override
	public List<User> findUserByGenderNot(String gender) {
		return userRepository.findByGenderNot(gender);
	}

	@Override
	public List<User> findUserByUsernameContaining(String username) {
		return userRepository.findByUsernameContaining(username);
	}

	@Override
	public List<User> findUserByUsernameIgnoreCase(String username) {
			return userRepository.findByUsernameIgnoreCase(username);
	}

	@Override
	public List<User> findUserByUsernameContainingIgnoreCase(String username) {
		return userRepository.findByUsernameContainingIgnoreCase(username);
	}

	@Override
	public List<User> findUserByAddressIn(List<String> address) {
		return userRepository.findByAddressIn(address);
	}

	@Override
	public List<User> findUserByGenderOrderByAddressAsc(String gender) {
		return userRepository.findByGenderOrderByAddressDesc(gender);
	}

	@Override
	public Page<User> findUserByPaginationAndSorting(int page, int size, String field) {
		return userRepository.findAll(PageRequest.of(page, size,Sort.by(field)));
	}

	@Override
	public Page<User> findUserByGender(String gender, int page, int size) {
		return userRepository.findByGender(gender, PageRequest.of(page, size));
	}

	@Override
	public List<User> searchUserByAddress(String address) {
		
		return userRepository.searchByAddress(address);
	}

	@Override
	public List<User> searchUserByGender(String gender) {
		
		return userRepository.searchByGender(gender);
	}

	@Override
	public List<User> searchUserByHobby(String hobby) {
		return userRepository.searchByHobby(hobby);
	}

	@Override
	public List<User> searchUserByAddressAgain(String address) {
		
		return userRepository.searchByAddressAgain(address);
	}
	
}