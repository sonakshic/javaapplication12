package com.example.javautility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;

import com.example.javaentity.Users;

@Component
public class JwtTokenUtil {

//	public static final long JWT_TOKEN_VALIDITY = 30 * 24 * 60 * 60; // days*hours*mim*sec
//
//	// generate token for user
//
//	public static final String SECRETE = "9121837953";
//
////	public String generateToken(Users user) {
////		Map<String, Object> claims = new HashMap<>();
////		return doGenerateToken(claims, user.getId());
////	}
////
////	private String doGenerateToken(Map<String, Object> claims, Long subject) {
////
////		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
////				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
////				.signWith(SignatureAlgorithm.HS512, SECRETE).compact();
////	}
//
//	public static String generateToken(String username) {
//		return Jwts.builder().setSubject(username)
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
//				.signWith(SignatureAlgorithm.HS512, SECRETE).compact();
//	}
//
//	public static String extractUsername(String token) {
//		return Jwts.parser().setSigningKey(SECRETE).parseClaimsJws(token).getBody().getSubject();
//	}

}
