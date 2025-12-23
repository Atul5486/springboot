package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Token;


public interface TokenRepo extends JpaRepository<Token, Integer> {
	
	public Token findByToken(String token);
}
