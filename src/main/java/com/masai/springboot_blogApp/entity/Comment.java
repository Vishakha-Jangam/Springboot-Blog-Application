package com.masai.springboot_blogApp.entity;

import javax.persistence.*;


@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	

    private String commentName;

    private String email;

    private String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

	public Comment() {
		super();
		
	}

	public Comment(Long commentId,String commentName,String email, String body, Post post) {
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
