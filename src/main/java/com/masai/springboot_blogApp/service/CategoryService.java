package com.masai.springboot_blogApp.service;

import java.util.List;

import com.masai.springboot_blogApp.DTO.CategoryDTO;

public interface CategoryService {

	CategoryDTO addCategory (CategoryDTO categoryDTO);
	
	CategoryDTO getCategory (Long categoryId);
	
	List<CategoryDTO> getAllCategories();
}
