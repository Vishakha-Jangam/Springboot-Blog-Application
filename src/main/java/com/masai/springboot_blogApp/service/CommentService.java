package com.masai.springboot_blogApp.service;

import java.util.List;

import com.masai.springboot_blogApp.DTO.CommentDTO;

public interface CommentService {

	CommentDTO createComment(long postId, CommentDTO commentDto);

	List<CommentDTO> getCommentsByPostId(long postId);
}
