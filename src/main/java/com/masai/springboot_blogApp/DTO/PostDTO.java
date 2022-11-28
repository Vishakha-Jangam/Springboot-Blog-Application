package com.masai.springboot_blogApp.DTO;

import java.time.LocalDateTime;

public class PostDTO {

	private Long postId;
	private String title;
	private String description;
	private String content;
	private LocalDateTime uploadDate;
	private LocalDateTime updateDate;
	
	
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostDTO(Long postId, String title, String description, String content, LocalDateTime uploadDate,
			LocalDateTime updateDate) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.uploadDate = uploadDate;
		this.updateDate = updateDate;
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


	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", title=" + title + ", description=" + description + ", content="
				+ content + ", uploadDate=" + uploadDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
