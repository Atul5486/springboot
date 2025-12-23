package com.springboot.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.entity.Token;
import com.springboot.repository.TokenRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TokenService {
	
	private TokenRepo tokenRepo;
	public TokenService(TokenRepo tokenRepo) {
		this.tokenRepo = tokenRepo;
	}
	
	public String createVerificationToken(User user) {
		Token vt = new Token();
		
		String token = UUID.randomUUID().toString();
		vt.setToken(token);
		vt.setUser(user);
		vt.setCreatedAt(LocalDateTime.now().plusHours(24));
		tokenRepo.save(vt);
		return token;
	}
	
	public Token findByToken(String token) {
		return tokenRepo.findByToken(token);
	}
}