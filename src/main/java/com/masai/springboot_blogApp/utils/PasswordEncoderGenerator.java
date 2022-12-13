package com.masai.springboot_blogApp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {
		PasswordEncoder password =new BCryptPasswordEncoder();
		System.out.println(password.encode("pass"));
	}
}
