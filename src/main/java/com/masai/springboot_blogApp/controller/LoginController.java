package com.masai.springboot_blogApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.JwtAuthResponse;
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
	
	  // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDto){
        String token = authService.userLogin(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto){
        String response = authService.userSignUp(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	
}
