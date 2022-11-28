package com.masai.springboot_blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
