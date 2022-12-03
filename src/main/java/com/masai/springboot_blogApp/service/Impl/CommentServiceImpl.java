package com.masai.springboot_blogApp.service.Impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.entity.Comment;
import com.masai.springboot_blogApp.entity.Post;
import com.masai.springboot_blogApp.exception.ResourceNotFoundException;
import com.masai.springboot_blogApp.repository.CommentRepository;
import com.masai.springboot_blogApp.repository.PostRepository;
import com.masai.springboot_blogApp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{


	private CommentRepository commentRepo;
	private PostRepository postRepo;
	

	public CommentServiceImpl(CommentRepository commentRepo, PostRepository postRepo) {
		this.commentRepo = commentRepo;
		this.postRepo = postRepo;
	}

	@Override
	public CommentDTO createComment(long postId, CommentDTO commentDto) {
		Comment comment = mapToEntity(commentDto);
		//find Post
		Post post = postRepo.findById(postId)
				             .orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
		//set Post to comment
		comment.setPost(post);
		//save comment to DB
		Comment newComment= commentRepo.save(comment);
		
		return mapToDTO(newComment);
	}

	@Override
	public List<CommentDTO> getCommentsByPostId(long postId) {
	
		List<Comment> comments = commentRepo.findByPostId(postId);
		
		return comments.stream().map(comment -> mapToDTO(comment))
				       .collect(Collectors.toList());
	}
	
	
	private CommentDTO mapToDTO(Comment comment) {
		CommentDTO commentDto = new CommentDTO();
		commentDto.setCommentId(comment.getcommentId());
		commentDto.setCommentName(comment.getcommentName());
		commentDto.setBody(comment.getBody());
		commentDto.setEmail(comment.getEmail());
		return commentDto;
	}
	
	private Comment mapToEntity(CommentDTO commentDto) {
		Comment comment = new Comment();
		comment.setcommentId(commentDto.getCommentId());
		comment.setcommentName(commentDto.getCommentName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		return comment;
	}

	
	
}
