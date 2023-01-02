package com.masai.springboot_blogApp.service.Impl;


import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.masai.springboot_blogApp.DTO.PostDTO;
import com.masai.springboot_blogApp.DTO.PostResponseDTO;
import com.masai.springboot_blogApp.entity.Post;
import com.masai.springboot_blogApp.exception.ResourceNotFoundException;
import com.masai.springboot_blogApp.repository.PostRepository;
import com.masai.springboot_blogApp.service.PostService;



@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepo;
	
	private ModelMapper mapper;
	
	
	public PostServiceImpl(PostRepository postRepo, ModelMapper mapper) {
		this.postRepo = postRepo;
		this.mapper = mapper;
	}

	@Override
	public PostDTO createNewPost(PostDTO postDto) {
		
		Post post = mapToEntity(postDto);
		post.setUploadDate(LocalDateTime.now());
		Post newPost = postRepo.save(post);
		PostDTO newPostDto = mapToDTO(newPost);
		
		return newPostDto;
	}
	
	@Override
	public PostResponseDTO getAllPosts(Integer pageNo, Integer pageSize, String sortBy,String sortType) {
		
		Sort sort= sortType.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
													: Sort.by(sortBy).descending();
		
		
		Pageable pageable =PageRequest.of(pageNo, pageSize,sort);
		
		Page<Post> page = postRepo.findAll(pageable);
		
		List<Post> posts=page.getContent();
		
		List<PostDTO> postDto = posts.stream()
									 .map(post -> mapToDTO(post))
									 .collect(Collectors.toList());
		
		PostResponseDTO postResponse = new PostResponseDTO();
		postResponse.setContent(postDto);
		postResponse.setPageNo(page.getNumber());
		postResponse.setPageSize(page.getSize());
		postResponse.setTotalElements(page.getTotalElements());
		postResponse.setTotalPages(page.getTotalPages());
		postResponse.setLast(page.isLast());
		return postResponse;
		
		
	
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

	//---------------------------------------------------------------------
	private Post mapToEntity(PostDTO postDto) {
		Post post =mapper.map(postDto, Post.class);
		
//		Post post =new Post();
//		post.setPostId(postDto.getPostId());
//		post.setTitle(postDto.getTitle());
//		post.setContent(postDto.getContent());
//		post.setDescription(postDto.getDescription());
//		post.setUpdatedDate(postDto.getUpdateDate());
//		post.setUploadDate(LocalDateTime.now());
		
		return post;
	}
	
	private PostDTO mapToDTO(Post post) {
		PostDTO postDto = mapper.map(post, PostDTO.class);
		
//		PostDTO postDto =new PostDTO();
//		postDto.setPostId(post.getPostId());
//		postDto.setTitle(post.getTitle());
//		postDto.setContent(post.getContent());
//		postDto.setDescription(post.getDescription());
//		postDto.setUploadDate(post.getUploadDate());
//		postDto.setUpdateDate(post.getUpdatedDate());
		
		return postDto;
	}

	

}
