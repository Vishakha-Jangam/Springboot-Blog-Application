package com.masai.springboot_blogApp.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer postId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@NotNull
	private String content;
	
	@NotNull
	private LocalDateTime uploadDate;
	
	
	private LocalDateTime updatedDate;


	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Post(Integer postId, @NotNull String title, @NotNull String description, @NotNull String content,
			@NotNull LocalDateTime uploadDate, LocalDateTime updatedDate) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.uploadDate = uploadDate;
		this.updatedDate = updatedDate;
	}


	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
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


	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", uploadDate=" + uploadDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
