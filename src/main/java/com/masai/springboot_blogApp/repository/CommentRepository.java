package com.masai.springboot_blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
