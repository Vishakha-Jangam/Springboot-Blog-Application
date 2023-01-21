package com.masai.springboot_blogApp.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catId;
	private String catName;
	private String description;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Post> posts;
	
	public Category() {
	}

	public Category(Long catId, String catName, String description, List<Post> posts) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.description = description;
		this.posts = posts;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", description=" + description + ", posts=" + posts
				+ "]";
	}

	
	
	
}
