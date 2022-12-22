package com.masai.springboot_blogApp.service;

import com.masai.springboot_blogApp.DTO.LoginDTO;
import com.masai.springboot_blogApp.DTO.RegisterDTO;

public interface AuthService {

	String userLogin(LoginDTO loginDto);
	
	String userSignUp(RegisterDTO registerDTO);
}
