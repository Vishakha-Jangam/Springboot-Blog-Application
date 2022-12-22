package com.masai.springboot_blogApp.service;

import com.masai.springboot_blogApp.DTO.LoginDTO;

public interface AuthService {

	String userLogin(LoginDTO loginDto);
}
