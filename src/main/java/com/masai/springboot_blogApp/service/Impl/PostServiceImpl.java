package com.masai.springboot_blogApp.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.blogDTO.PostDTO;
import com.masai.springboot_blogApp.entity.Posts;
import com.masai.springboot_blogApp.repository.PostRepository;
import com.masai.springboot_blogApp.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public PostDTO createNewPost(PostDTO postDto) {
		
		Posts post = mapToEntity(postDto);
		post.setUploadDate(LocalDateTime.now());
		Posts newPost = postRepo.save(post);
		PostDTO newPostDto = mapToDTO(newPost);
		
		return newPostDto;
	}
	
	private Posts mapToEntity(PostDTO postDto) {
		Posts post =new Posts();
		
		post.setPostId(postDto.getPostId());
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setUpdatedDate(postDto.getUpdateDate());
		post.setUploadDate(LocalDateTime.now());
		
		return post;
	}
	
	private PostDTO mapToDTO(Posts post) {
		PostDTO postDto =new PostDTO();
		
		postDto.setPostId(post.getPostId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		postDto.setUploadDate(post.getUploadDate());
		postDto.setUpdateDate(post.getUpdatedDate());
		
		return postDto;
	}

}
