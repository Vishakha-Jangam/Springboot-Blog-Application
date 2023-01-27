package com.masai.springboot_blogApp.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping("/get/{catId}")
	public ResponseEntity<CategoryDTO> getCategoryHandle(@PathVariable("catId") Long catId){
		CategoryDTO categoryDTO =  categoryService.getCategory(catId);
		return ResponseEntity.ok(categoryDTO);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesHandle(){
		List<CategoryDTO> list = categoryService.getAllCategories();
		return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategoryHandle(@RequestBody CategoryDTO categoryDTO,
			@PathVariable("catId") Long catId){
		return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, catId));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{catId}")
	public ResponseEntity<String> deleteCategoryHandle(@PathVariable("catId") Long catId){
		return ResponseEntity.ok(categoryService.deleteCategory(catId));
	}
}
