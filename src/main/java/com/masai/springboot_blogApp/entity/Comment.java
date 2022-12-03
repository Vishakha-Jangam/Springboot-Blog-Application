package com.masai.springboot_blogApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	@NotNull
    private String commentName;
	
	@NotNull
    private String email;
	
	@NotNull
    private String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

	public Comment() {
		super();
		
	}

	public Comment(Long commentId, @NotNull String commentName, @NotNull String email, @NotNull String body, Post post) {
		super();
		this.commentId = commentId;
		this.commentName = commentName;
		this.email = email;
		this.body = body;
		this.post = post;
	}

	public Long getcommentId() {
		return commentId;
	}

	public void setcommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getcommentName() {
		return commentName;
	}

	public void setcommentName(String commentName) {
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentName=" + commentName + ", email=" + email + ", body=" + body + ", post=" + post + "]";
	}
	
	
}
