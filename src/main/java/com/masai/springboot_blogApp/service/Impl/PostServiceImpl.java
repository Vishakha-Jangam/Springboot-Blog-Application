package com.masai.springboot_blogApp.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.masai.springboot_blogApp.DTO.PostDTO;
import com.masai.springboot_blogApp.entity.Post;
import com.masai.springboot_blogApp.exception.ResourceNotFoundException;
import com.masai.springboot_blogApp.repository.PostRepository;
import com.masai.springboot_blogApp.service.PostService;



@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public PostDTO createNewPost(PostDTO postDto) {
		
		Post post = mapToEntity(postDto);
		post.setUploadDate(LocalDateTime.now());
		Post newPost = postRepo.save(post);
		PostDTO newPostDto = mapToDTO(newPost);
		
		return newPostDto;
	}
	
	@Override
	public List getAllPosts() {
		 
		List<Post> posts= postRepo.findAll();
		return posts.stream()
				    .map(post -> mapToDTO(post))
				    .collect(Collectors.toList());
	}

	
	@Override
	public PostDTO getPostById(Long postId) {
     	Post post=postRepo.findById(postId)
     					  .orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
   
		return mapToDTO(post);
	}


	@Override
	public PostDTO updatePost(PostDTO postDto, Long postId) {
		
		Post post = postRepo.findById(postId)
							.orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		
		if(postDto.getTitle()!=null) {
			post.setTitle(postDto.getTitle());
		}
		if(postDto.getContent()!=null) {
			post.setContent(postDto.getContent());
		}
		if(postDto.getDescription()!=null) {
			post.setDescription(postDto.getDescription());
		}
		
		post.setUpdatedDate(LocalDateTime.now());
		Post updatePost = postRepo.save(post);
		
		return mapToDTO(updatePost);
	}


	@Override
	public String deletePost(Long postId) {
		
		Post post = postRepo.findById(postId)
							.orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		postRepo.delete(post);
		return "Post Deleted Successfully....";
	}


	@Override
	public List<PostDTO> getPostByTitle(String title) {
		
	 List<Post> posts= postRepo.findByTitleContainingIgnoreCase(title);
	 if(posts.size()==0) {
		 throw new ResourceNotFoundException("Post","title",title);
	 }
	 return posts.stream()
			     .map(post -> mapToDTO(post))
			     .collect(Collectors.toList());
			 
	 
	}


	@Override
	public List<PostDTO> getPostsByDate(Integer year, Integer month, Integer date) {
		LocalDateTime startdDateTime = LocalDateTime.of(year, month,date,00,01);
		LocalDateTime endDateTime= LocalDateTime.of(year, month,date,23,59);
		
		List<Post> posts = postRepo.findByUploadDateBetween(startdDateTime, endDateTime);
		return posts.stream()
					 .map(post -> mapToDTO(post))
					 .collect(Collectors.toList());
	}

	
	private Post mapToEntity(PostDTO postDto) {
		Post post =new Post();
		
		post.setPostId(postDto.getPostId());
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setUpdatedDate(postDto.getUpdateDate());
		post.setUploadDate(LocalDateTime.now());
		
		return post;
	}
	
	private PostDTO mapToDTO(Post post) {
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
