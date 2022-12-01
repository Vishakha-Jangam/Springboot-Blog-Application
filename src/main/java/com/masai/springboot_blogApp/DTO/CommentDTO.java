package com.masai.springboot_blogApp.DTO;


public class CommentDTO {

	private Long commentId;
	private String commentName;
	private String email;
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
