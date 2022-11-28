package com.masai.springboot_blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Long>{

}
