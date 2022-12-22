package com.masai.springboot_blogApp.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.LoginDTO;
import com.masai.springboot_blogApp.DTO.RegisterDTO;
import com.masai.springboot_blogApp.entity.Roles;
import com.masai.springboot_blogApp.entity.User;
import com.masai.springboot_blogApp.exception.BlogApiException;
import com.masai.springboot_blogApp.repository.RolesRepository;
import com.masai.springboot_blogApp.repository.UserRepository;
import com.masai.springboot_blogApp.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RolesRepository rolesRepository;
	private PasswordEncoder passwordEncoder;
	
	
	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {

		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.rolesRepository = rolesRepository;
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public String userLogin(LoginDTO loginDto) {
	Authentication authentication =authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken
				(loginDto.getUserNameOrEmail(), loginDto.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
		return "User Logged in Successfully!...";
	}



	@Override
	public String userSignUp(RegisterDTO registerDTO) {
		
		if(userRepository.existsByUserName(registerDTO.getUserName())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "UserName already exists");
		}
		
		if(userRepository.existsByEmail(registerDTO.getEmail())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Email Id already exists");
		}
		
		User user = new User();
		user.setName(registerDTO.getName());
		user.setUserName(registerDTO.getUserName());
		user.setEmail(registerDTO.getEmail());
		user.setPassword(registerDTO.getPassword());
		
		Set<Roles> roles = new HashSet<>();
		Roles userrole = rolesRepository.findByname("ROLE_USER").get();
		roles.add(userrole);
		user.setRoles(roles);
		
		userRepository.save(user);
		
		return "User Register Successfully...";
	}

}
