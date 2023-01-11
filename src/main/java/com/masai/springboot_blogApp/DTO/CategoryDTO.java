package com.masai.springboot_blogApp.DTO;

public class CategoryDTO {

	private Long catId;
	private String catName;
	private String description;
	public CategoryDTO() {

	}
	public CategoryDTO(Long catId, String catName, String description) {
		this.catId = catId;
		this.catName = catName;
		this.description = description;
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
	@Override
	public String toString() {
		return "CategoryDTO [catId=" + catId + ", catName=" + catName + ", description=" + description + "]";
	}
	
	
}
