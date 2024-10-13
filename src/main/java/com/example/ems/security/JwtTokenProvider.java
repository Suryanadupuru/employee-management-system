package com.example.ems.security;

import java.security.SignatureException;
import java.util.Date;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@lombok.extern.java.Log
public class JwtTokenProvider {
	
	//private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
	@Value("${jwt.secret}")
	private String JwtSecret;
	
	@Value("${jwt.expiration}")
	private int jwtExpirationMs;

	public String generateToken(Authentication authentication) {
		UserDetails userPrinciple=(UserDetails)authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject(userPrinciple.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, JwtSecret)
				.compact();
				
	}
	public String getUsernameFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(JwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JwtSecret).parseClaimsJwt(token);
			return true;
		}
		catch(Exception e) {
			log.error("JWT validation error: {}", e.getMessage());
		}
//		catch(SignatureException e){
//			log.error("Invalid JWT signature: {}", e.getMessage());
//		}
//		catch(MalFormedJwtException e){
//			log.error("Invalid JWT token: {}", e.getMessage());
//		}
//		catch(ExpairedJwtException e){
//			log.error("JWT Token is expaired: {}", e.getMessage());
//		}
//		catch(UnsupportedJwtException e){
//			log.error("JWT token is unsupported: {}", e.getMessage());
//		}
//		catch(IllegalArgumentException e){
//			log.error("JWT claims string is empty: {}", e.getMessage());
//		}
		return false;
	}
	

}
