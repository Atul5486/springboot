package com.springboot.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	
	public CustomUserDetailsService(UserRepository userRepository) {
		 this.userRepository=userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		System.out.println("-".repeat(50));
		System.out.println(user);
		System.out.println("-".repeat(50));
		
		return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					user.getRole().stream()
					.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
					.toList()
				);
				
	}
	
	
	
}