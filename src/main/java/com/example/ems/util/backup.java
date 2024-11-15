package com.example.ems.util;

public class backup {

//	package com.example.ems.security;
//
//	import java.nio.charset.StandardCharsets;
//	import java.security.SignatureException;
//	import java.util.Date;
//
//	import javax.crypto.SecretKey;
//
//	import io.jsonwebtoken.*;
//	import io.jsonwebtoken.security.Keys;
//	import jakarta.annotation.PostConstruct;
//	import lombok.extern.slf4j.Slf4j;
//
//	import org.slf4j.Logger;
//	import org.slf4j.LoggerFactory;
//
//	import org.apache.commons.logging.Log;
//	import org.springframework.beans.factory.annotation.Value;
//	import org.springframework.security.core.Authentication;
//	import org.springframework.security.core.userdetails.UserDetails;
//	import org.springframework.stereotype.Component;
//
//
//	@Component
//	@Slf4j
//	public class JwtTokenProvider {
//		
//		@Value("${jwt.secret}")
//		private String JwtSecret;
//		
//		@Value("${jwt.expiration}")
//		private int jwtExpirationMs;
//		
//		private SecretKey key;
//
//		    @PostConstruct
//		    public void init() {
//		        byte[] keyBytes = JwtSecret.getBytes(StandardCharsets.UTF_8);
//		        this.key = Keys.hmacShaKeyFor(keyBytes);
//		    }
//
//		public String generateToken(Authentication authentication) {
//			UserDetails userPrinciple=(UserDetails)authentication.getPrincipal();
//			
//			Date now = new Date();
//	        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
//			
//			return Jwts.builder()
//					.setSubject(userPrinciple.getUsername())
//					.setIssuedAt(now)
//					.setExpiration(expiryDate)
//					.signWith(key,SignatureAlgorithm.HS512)
//					.compact();
//					
//		}
//		public String getUsernameFromToken(String token) {
//			return Jwts.parser()
//					.setSigningKey(JwtSecret)
//					.parseClaimsJws(token)
//					.getBody()
//					.getSubject();
//		}
//		
//		public boolean validateToken(String token) {
//			try {
//				Jwts.parser().setSigningKey(JwtSecret).parseClaimsJwt(token);
//				return true;
//			}
//			catch(Exception e) {
//				log.error("JWT validation error: {}", e.getMessage());
//			}
////			catch(SignatureException e){
////				log.error("Invalid JWT signature: {}", e.getMessage());
////			}
////			catch(MalFormedJwtException e){
////				log.error("Invalid JWT token: {}", e.getMessage());
////			}
////			catch(ExpairedJwtException e){
////				log.error("JWT Token is expaired: {}", e.getMessage());
////			}
////			catch(UnsupportedJwtException e){
////				log.error("JWT token is unsupported: {}", e.getMessage());
////			}
////			catch(IllegalArgumentException e){
////				log.error("JWT claims string is empty: {}", e.getMessage());
////			}
//			return false;
//		}
//		
//
//	}

}