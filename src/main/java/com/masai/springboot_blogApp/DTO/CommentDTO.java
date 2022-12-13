package com.masai.springboot_blogApp.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentDTO {

	private Long commentId;
	
	@NotEmpty(message ="Name should not be null or empty.")
	private String commentName;
	
	@NotEmpty(message = "Email should not be null or empty.")
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=10, message = "Content body must be minimum 10 characters.")
	private String body;
	
	public CommentDTO() {
		super();
		
	}
	public CommentDTO(Long commentId, String commentName, String email, String body) {
		super();
		this.commentId = commentId;
		this.commentName = commentName;
		this.email = email;
		this.body = body;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", commentName=" + commentName + ", email=" + email + ", body="
				+ body + "]";
	}
	
	
}
