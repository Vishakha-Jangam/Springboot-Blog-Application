package com.masai.springboot_blogApp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.repository.CommentRepository;
import com.masai.springboot_blogApp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public CommentDTO createComment(long postId, CommentDTO commentDto) {
		
		return null;
	}

	
}
