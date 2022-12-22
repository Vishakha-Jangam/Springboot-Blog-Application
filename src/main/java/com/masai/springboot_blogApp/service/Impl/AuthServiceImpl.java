package com.masai.springboot_blogApp.service.Impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.LoginDTO;
import com.masai.springboot_blogApp.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	private AuthenticationManager authenticationManager;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}



	@Override
	public String userLogin(LoginDTO loginDto) {
	Authentication authentication =authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken
				(loginDto.getUserNameOrEmail(), loginDto.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
		return "User Logged in Successfully!...";
	}

}
