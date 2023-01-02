package com.masai.springboot_blogApp.service;

import com.masai.springboot_blogApp.DTO.*;

public interface AuthService {

	String userLogin(LoginDTO loginDto);
	
	String userSignUp(RegisterDTO registerDTO);
}
