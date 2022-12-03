package com.masai.springboot_blogApp.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@NotNull
	private String content;
	
	private LocalDateTime uploadDate;
	
	private LocalDateTime updatedDate;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();


	public Post() {
		super();

	}


	public Post(Long postId, @NotNull String title, @NotNull String description, @NotNull String content,
			LocalDateTime uploadDate, LocalDateTime updatedDate, Set<Comment> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.uploadDate = uploadDate;
		this.updatedDate = updatedDate;
		this.comments = comments;
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


	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", uploadDate=" + uploadDate + ", updatedDate=" + updatedDate + ", comments=" + comments + "]";
	}


	
	
}
