package com.masai.springboot_blogApp.Security;


import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.masai.springboot_blogApp.exception.BlogApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secrete}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-miliseconds}")
	private long jwtExpirationDate;
	
	//generate JWT token
	
	public String generateToken(Authentication authentication) {
		String userName = authentication.getName();

		Date currentDate = new Date();
		
		Date expireDate =new Date(currentDate.getTime() + jwtExpirationDate);
		
		String token= Jwts.builder()
			.setSubject(userName)
			.setIssuedAt(new Date())
			.setExpiration(expireDate)
			.signWith(key())
			.compact();
		
		return token;
	}

	private Key key() {	
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	//get username from jwt Token
	public String getUserName(String token) {
		
	Claims claims=Jwts.parserBuilder()
			.setSigningKey(key())
			.build()
			.parseClaimsJws(token)
			.getBody();
	
	String username = claims.getSubject();
	return username;
	}
	
	//Validate JWT token 
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
			.setSigningKey(key())
			.build()
			.parse(token);
		return true;
		}catch(MalformedJwtException ex) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Invalid Jwt token");
		}catch(ExpiredJwtException ex) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Expired Jwt Token");
		}catch(UnsupportedJwtException ex) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Unsupported Jwt Token");
		}catch(IllegalArgumentException ex) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Jwt claims String is empty");
		}
	}
}
