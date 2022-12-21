package com.masai.springboot_blogApp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	Optional<Roles> findByname(String name);
}