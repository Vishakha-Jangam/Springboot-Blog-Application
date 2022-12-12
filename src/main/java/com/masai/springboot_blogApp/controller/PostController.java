package com.masai.springboot_blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.masai.springboot_blogApp.DTO.PostDTO;
import com.masai.springboot_blogApp.DTO.PostResponseDTO;
import com.masai.springboot_blogApp.service.PostService;
import com.masai.springboot_blogApp.utils.PageSortConstants;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	
	@PostMapping("/posts")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PostDTO> createNewPostController(@Valid @RequestBody PostDTO postDto){
		return new ResponseEntity<>(postService.createNewPost(postDto),HttpStatus.CREATED);
	}
	
	
	@GetMapping()
	public ResponseEntity<PostResponseDTO> getAllPostsController(
			@RequestParam(value = "pageNo", defaultValue=PageSortConstants.DEFAULT_PAGE_NO, required=false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue =PageSortConstants.DEFAULT_PAGE_SIZE, required=false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue =PageSortConstants.DEFAULT_SORT_BY, required=false) String sortBy,
			@RequestParam(value = "sortType", defaultValue =PageSortConstants.DEFAULT_SORT_TYPE, required=false) String sortType
			){
		return new ResponseEntity<PostResponseDTO>(postService.getAllPosts(pageNo,pageSize,sortBy,sortType),HttpStatus.FOUND);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getPostByIdController(@PathVariable ("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.getPostById(postId),HttpStatus.FOUND);
	}
	
	
	@PutMapping("/posts/{postId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PostDTO> updatePostController(@Valid @RequestBody PostDTO postDto, @PathVariable("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.updatePost(postDto, postId),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{postId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deletePostController(@PathVariable("postId") Long PostId){
		return new ResponseEntity<String>(postService.deletePost(PostId),HttpStatus.OK);
	}
	
	@GetMapping("/title")
	public ResponseEntity<List<PostDTO>> getPostsByTitleController(@RequestParam String title){
		return new ResponseEntity<List<PostDTO>>(postService.getPostByTitle(title),HttpStatus.FOUND);
	}
	
	@GetMapping("/getpost/{year}/{month}/{date}")
	public ResponseEntity<List<PostDTO>> getPostBydateController(
			  @PathVariable("year") Integer year,
			  @PathVariable("month")Integer month,
			  @PathVariable("date")Integer date){
				return new ResponseEntity<>(postService.getPostsByDate(year,month, date),HttpStatus.FOUND);
		
	}
}
