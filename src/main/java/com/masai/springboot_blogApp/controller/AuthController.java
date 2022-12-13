package com.masai.springboot_blogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.LoginDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO logindto){
   Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
				(logindto.getUserNameOrEmail(), logindto.getPassword()));
   
   SecurityContextHolder.getContext().setAuthentication(authentication);
   return new ResponseEntity<String>("Signin successfully..",HttpStatus.OK);
	}
}
