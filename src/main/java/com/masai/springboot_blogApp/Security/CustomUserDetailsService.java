package com.masai.springboot_blogApp.Security;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.entity.*;
import com.masai.springboot_blogApp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	private UserRepository userRepository;
	
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUserNameOrEmail(usernameOrEmail,usernameOrEmail)
				.orElseThrow(()->
				new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), 
																		user.getPassword(), 
																		mapToRolesAuthority(user.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapToRolesAuthority(Set<Roles> roles){
	   return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
