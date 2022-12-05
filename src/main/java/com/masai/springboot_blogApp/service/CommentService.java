package com.masai.springboot_blogApp.service;

import java.util.List;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.entity.Comment;

public interface CommentService {

	CommentDTO createComment(long postId, CommentDTO commentDto);

	List<CommentDTO> getCommentsByPostId(Long postId);
	
	CommentDTO getCommentById(long postd,Long commentId);
	
	CommentDTO updateComment(long postId, long commentId, CommentDTO commentDto);
	
	String deleteComment(long postId, long commentId);
}
