package com.masai.springboot_blogApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.springboot_blogApp.DTO.CategoryDTO;
import com.masai.springboot_blogApp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CategoryDTO> addCategoryHandle(@RequestBody CategoryDTO categoryDTO){
		CategoryDTO savedCategory = categoryService.addCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(savedCategory,HttpStatus.CREATED);
	}
	

}
