package com.masai.springboot_blogApp.service;

import com.masai.springboot_blogApp.DTO.*;

import java.util.List;

public interface PostService {
	
	public PostDTO createNewPost (PostDTO postDto);
	
	public PostResponseDTO getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortType);
	
	public PostDTO getPostById(Long postId);
	
	public PostDTO updatePost (PostDTO postDto, Long postId);
	
	public String deletePost(Long postId);
	
	public List<PostDTO> getPostByTitle(String title);
	
	public List<PostDTO> getPostsByDate(Integer year, Integer month, Integer date);
	
}
