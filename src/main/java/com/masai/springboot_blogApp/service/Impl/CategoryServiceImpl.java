package com.masai.springboot_blogApp.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.CategoryDTO;
import com.masai.springboot_blogApp.entity.Category;
import com.masai.springboot_blogApp.repository.CategoryRepository;
import com.masai.springboot_blogApp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	private ModelMapper modelMapper;
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		
		Category category =modelMapper.map(categoryDTO, Category.class);
		Category savedCategory  =categoryRepository.save(category);
		
		return modelMapper.map(savedCategory, CategoryDTO.class);
	}

}
