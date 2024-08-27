package com.grabhub.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRECT_KEY.getBytes());
		public String generateToken(Authentication Auth)
		{
//			
			String Jwt=Jwts.builder()
					 
					.setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime()+84600000))
					.claim("email", Auth.getName())
					.signWith(key).compact();
					
			return Jwt;
			
		}
public String getEmailFromToken(String jwt) {
	
	jwt=jwt.substring(7);
	
	
	Claims claims =(Claims) Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt);
	
	String email=String.valueOf(claims.get("email"));
	
	return email;
	
	
}
}
