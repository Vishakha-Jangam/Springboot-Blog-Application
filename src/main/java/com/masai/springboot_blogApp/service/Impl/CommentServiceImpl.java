package com.masai.springboot_blogApp.service.Impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.CommentDTO;
import com.masai.springboot_blogApp.entity.Comment;
import com.masai.springboot_blogApp.entity.Post;
import com.masai.springboot_blogApp.exception.BlogApiException;
import com.masai.springboot_blogApp.exception.ResourceNotFoundException;
import com.masai.springboot_blogApp.repository.CommentRepository;
import com.masai.springboot_blogApp.repository.PostRepository;
import com.masai.springboot_blogApp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{


	private CommentRepository commentRepo;
	private PostRepository postRepo;
	private ModelMapper mapper;

	public CommentServiceImpl(CommentRepository commentRepo, PostRepository postRepo,ModelMapper mapper) {
		this.commentRepo = commentRepo;
		this.postRepo = postRepo;
		this.mapper=mapper;
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
	public List<CommentDTO> getCommentsByPostId(Long postId) {
	
		List<Comment> comments = commentRepo.findByPostPostId(postId);
		
		return comments.stream().map(comment -> mapToDTO(comment))
				       .collect(Collectors.toList());
	}
	
	@Override
	public CommentDTO getCommentById(long postId,Long commentId) {
		
		Post post =postRepo.findById(postId)
						    .orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
		
		Comment comment = commentRepo.findById(commentId)
									  .orElseThrow(() ->
									  new ResourceNotFoundException("Comment","commentId", commentId));
		
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		
		return mapToDTO(comment);

	}
	

	@Override
	public CommentDTO updateComment(long postId, long commentId, CommentDTO commentDto) {
		Post post =postRepo.findById(postId)
			    .orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));

		Comment comment = commentRepo.findById(commentId)
								  .orElseThrow(() ->
								  new ResourceNotFoundException("Comment","commentId", commentId));
		
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
		throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		
		comment.setcommentName(commentDto.getCommentName());
		comment.setBody(commentDto.getBody());
		comment.setEmail(commentDto.getEmail());
		
		Comment updated =commentRepo.save(comment);
		
		return mapToDTO(updated);
	}

	@Override
	public String deleteComment(long postId, long commentId) {
		Post post =postRepo.findById(postId)
			    .orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));

		Comment comment = commentRepo.findById(commentId)
								  .orElseThrow(() ->
								  new ResourceNotFoundException("Comment","commentId", commentId));
		
		if(!comment.getPost().getPostId().equals(post.getPostId())) {
		throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		
		commentRepo.delete(comment);
		return "comment Deleted successfully..";
		
	}

	//--------------------------------------------------------------------
	
	private CommentDTO mapToDTO(Comment comment) {
		CommentDTO commentDto =mapper.map(comment, CommentDTO.class);
		
//		CommentDTO commentDto = new CommentDTO();
//		commentDto.setCommentId(comment.getcommentId());
//		commentDto.setCommentName(comment.getcommentName());
//		commentDto.setBody(comment.getBody());
//		commentDto.setEmail(comment.getEmail());
		return commentDto;
	}
	
	private Comment mapToEntity(CommentDTO commentDto) {
		Comment comment =mapper.map(commentDto, Comment.class);
		
//		Comment comment = new Comment();
//		comment.setcommentId(commentDto.getCommentId());
//		comment.setcommentName(commentDto.getCommentName());
//		comment.setEmail(commentDto.getEmail());
//		comment.setBody(commentDto.getBody());
		return comment;
	}

	
	
}
