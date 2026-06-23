package com.Basic_Authentication.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Configuration
public class JWTUtils {

    private final String SECRET_KEY="qwertyuioplkjhgfdsazxcvbnm123456";

    public Key getKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String email,String role){

        return Jwts.builder()
                .setSubject(email)
                .addClaims(Map.of("role",role))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+860000))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims validateToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public int generateOtp() {
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }

}
