package com.springboot.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService{
	
	public final String SECRET="jwt_s65486132sdfsdfsd23fecret5dsf1s56d4f632sa215";
	
	public String generateToken(String username) {
		Key key=Keys.hmacShaKeyFor(SECRET.getBytes());
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+600000))
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();
				
	}
	
	public boolean validateToken(String token) {
		try {
			Key key=Keys.hmacShaKeyFor(SECRET.getBytes());
			Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
			
			return true;
		}catch(Exception ex) {
			System.out.println("Exception "+ex);
			return false;
		}
	}
	
	
}