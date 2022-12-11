package com.masai.springboot_blogApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByUserName(String userName);
	
	Optional<User> findByUserNameOrEmail(String userName,String email);
	
	Optional<User> findByEmail(String email);
	
	boolean existsByUserName(String userName);
	
	boolean existsByEmail(String email);
	
}
