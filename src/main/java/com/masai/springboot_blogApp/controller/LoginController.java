package com.masai.springboot_blogApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.LoginDTO;
import com.masai.springboot_blogApp.DTO.RegisterDTO;
import com.masai.springboot_blogApp.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

	
	private AuthService authService;

	public LoginController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping(value = {"/login","/signin"})
	public ResponseEntity<String> UserLoginHandler(@RequestBody LoginDTO loginDTO){
		String response = authService.userLogin(loginDTO);
		return ResponseEntity.ok(response);
	}
	
	
	
	public ResponseEntity<String> UserRegisterHandler(@RequestBody RegisterDTO registerDTO){
		String response = authService.userSignUp(registerDTO);
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	
}
