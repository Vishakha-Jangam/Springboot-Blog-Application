package com.masai.springboot_blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.PostDTO;
import com.masai.springboot_blogApp.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/")
	public ResponseEntity<PostDTO> createNewPostController(@RequestBody PostDTO postDto){
		return new ResponseEntity<>(postService.createNewPost(postDto),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<PostDTO>> getAllPostsController(){
		return new ResponseEntity<List<PostDTO>>(postService.getAllPosts(),HttpStatus.FOUND);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getPostByIdController(@PathVariable ("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.getPostById(postId),HttpStatus.FOUND);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDTO> updatePostController(@RequestBody PostDTO postDto, @PathVariable("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.updatePost(postDto, postId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostController(@PathVariable("postId") Long PostId){
		return new ResponseEntity<String>(postService.deletePost(PostId),HttpStatus.OK);
	}
}
