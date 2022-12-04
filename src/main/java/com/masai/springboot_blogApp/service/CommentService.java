package com.masai.springboot_blogApp.service;

import java.util.List;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.entity.Comment;

public interface CommentService {

	CommentDTO createComment(long postId, CommentDTO commentDto);

	List<CommentDTO> getCommentsByPostId(long postId);
	
	Comment getCommentById(Long commentId);
}
