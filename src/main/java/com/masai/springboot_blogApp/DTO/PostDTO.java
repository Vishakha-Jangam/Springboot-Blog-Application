package com.masai.springboot_blogApp.DTO;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.*;



public class PostDTO {

	private Long postId;
	
	@NotEmpty
	@Size(min =2 , message="Post title should have at least 2 characters.")
	private String title;
	
	@NotEmpty
	@Size(min =10, message ="Post description should have at least 10 characters.")
	private String description;
	
	@NotEmpty
	private String content;
	private LocalDateTime uploadDate;
	private LocalDateTime updateDate;
	private Set<CommentDTO> comments;
	
	private Long categoryId;
	public PostDTO() {
		
	}
	public PostDTO(Long postId,
			@NotEmpty @Size(min = 2, message = "Post title should have at least 2 characters.") String title,
			@NotEmpty @Size(min = 10, message = "Post description should have at least 10 characters.") String description,
			@NotEmpty String content, LocalDateTime uploadDate, LocalDateTime updateDate, Set<CommentDTO> comments,
			Long categoryId) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.uploadDate = uploadDate;
		this.updateDate = updateDate;
		this.comments = comments;
		this.categoryId = categoryId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public Set<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", title=" + title + ", description=" + description + ", content="
				+ content + ", uploadDate=" + uploadDate + ", updateDate=" + updateDate + ", comments=" + comments
				+ ", categoryId=" + categoryId + "]";
	}

	
}
