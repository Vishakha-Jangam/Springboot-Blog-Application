package com.masai.springboot_blogApp.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.masai.springboot_blogApp.DTO.PostDTO;
import com.masai.springboot_blogApp.DTO.PostDTOv2;
import com.masai.springboot_blogApp.DTO.PostResponseDTO;
import com.masai.springboot_blogApp.service.PostService;
import com.masai.springboot_blogApp.utils.PageSortConstants;



@RestController
@RequestMapping()
public class PostController {

	@Autowired
	private PostService postService;

	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/api/v1/posts")
	public ResponseEntity<PostDTO> createNewPostController(@Valid @RequestBody PostDTO postDto){
		return new ResponseEntity<>(postService.createNewPost(postDto),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/v1/posts")
	public ResponseEntity<PostResponseDTO> getAllPostsController(
			@RequestParam(value = "pageNo", defaultValue=PageSortConstants.DEFAULT_PAGE_NO, required=false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue =PageSortConstants.DEFAULT_PAGE_SIZE, required=false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue =PageSortConstants.DEFAULT_SORT_BY, required=false) String sortBy,
			@RequestParam(value = "sortType", defaultValue =PageSortConstants.DEFAULT_SORT_TYPE, required=false) String sortType
			){
		return new ResponseEntity<PostResponseDTO>(postService.getAllPosts(pageNo,pageSize,sortBy,sortType),HttpStatus.FOUND);
	}
	
	@GetMapping("/api/v1/{postId}")
	public ResponseEntity<PostDTO> getPostByIdControllerv1(@PathVariable ("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.getPostById(postId),HttpStatus.FOUND);
	}
	
	@GetMapping("/api/v2/{postId}")
	public ResponseEntity<PostDTOv2> getPostByIdControllerv2(@PathVariable ("postId") Long postId){
		PostDTO postdto = postService.getPostById(postId);
		PostDTOv2 postDTOv2 = new PostDTOv2();
		postDTOv2.setPostId(postdto.getPostId());
		postDTOv2.setTitle(postdto.getTitle());
		postDTOv2.setDescription(postdto.getDescription());
		postDTOv2.setContent(postdto.getContent());
		postDTOv2.setCategoryId(postdto.getCategoryId());
		postDTOv2.setComments(postdto.getComments());
		postDTOv2.setUpdateDate(postdto.getUpdateDate());
		postDTOv2.setUploadDate(postdto.getUploadDate());
		List<String> tags =new ArrayList<>();
		tags.add("Java");
		tags.add("Spring Boot");
		tags.add("AWS");
		
		postDTOv2.setTags(tags);
		return  ResponseEntity.ok(postDTOv2);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/api/v1/posts/{postId}")
	public ResponseEntity<PostDTO> updatePostController(@Valid @RequestBody PostDTO postDto, @PathVariable("postId") Long postId){
		return new ResponseEntity<PostDTO>(postService.updatePost(postDto, postId),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/api/v1/{postId}")
	public ResponseEntity<String> deletePostController(@PathVariable("postId") Long PostId){
		return new ResponseEntity<String>(postService.deletePost(PostId),HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/title")
	public ResponseEntity<List<PostDTO>> getPostsByTitleController(@RequestParam String title){
		return new ResponseEntity<List<PostDTO>>(postService.getPostByTitle(title),HttpStatus.FOUND);
	}
	
	@GetMapping("/api/v1/getpost/{year}/{month}/{date}")
	public ResponseEntity<List<PostDTO>> getPostBydateController(
			  @PathVariable("year") Integer year,
			  @PathVariable("month")Integer month,
			  @PathVariable("date")Integer date){
				return new ResponseEntity<>(postService.getPostsByDate(year,month, date),HttpStatus.FOUND);
		
	}
}
