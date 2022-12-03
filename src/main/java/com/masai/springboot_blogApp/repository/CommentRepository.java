package com.masai.springboot_blogApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPostId(long postId);
}
