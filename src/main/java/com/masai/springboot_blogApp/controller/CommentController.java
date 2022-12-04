package com.masai.springboot_blogApp.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	
	private CommentService commentServ;


	public CommentController(CommentService commentServ) {
		this.commentServ = commentServ;
	}
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(@PathVariable("postId")
	 long postId, @RequestBody CommentDTO commentDto){
		return new ResponseEntity<CommentDTO>(commentServ.createComment(postId, commentDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/posts/{postId}/comments")
	public List<CommentDTO> getAllCommentByPostId(@PathVariable("postId") Long postId){
		return commentServ.getCommentsByPostId(postId);
	}
}
