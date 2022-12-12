package com.masai.springboot_blogApp.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CommentController {

	
	private CommentService commentServ;


	public CommentController(CommentService commentServ) {
		this.commentServ = commentServ;
	}
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(@PathVariable("postId")
	                                               long postId,@Valid @RequestBody CommentDTO commentDto){
		return new ResponseEntity<CommentDTO>(commentServ.createComment(postId, commentDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/posts/{postId}/comments")
	public List<CommentDTO> getAllCommentByPostId(@PathVariable("postId") Long postId){
		return commentServ.getCommentsByPostId(postId);
	}
	
	
	@GetMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDTO> getCommentsById(@PathVariable("postId") long postId,
			@PathVariable("commentId" )long commentId){
		return new ResponseEntity<CommentDTO>(commentServ.getCommentById(postId, commentId),HttpStatus.OK);
	}
	
	@PutMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDTO> updateComment(
													@PathVariable("postId") long postId,
													@PathVariable("commentId") long commentId,
													@Valid @RequestBody CommentDTO commentDto){
		return new ResponseEntity<CommentDTO>(commentServ.updateComment(postId, commentId, commentDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId,
												@PathVariable ("commentId") long commentId){
		return new ResponseEntity<String>(commentServ.deleteComment(postId, commentId),HttpStatus.OK);
	}
}