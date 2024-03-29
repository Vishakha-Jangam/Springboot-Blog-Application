package com.masai.springboot_blogApp.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.masai.springboot_blogApp.DTO.CategoryDTO;
import com.masai.springboot_blogApp.entity.Category;
import com.masai.springboot_blogApp.exception.ResourceNotFoundException;
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


	@Override
	public CategoryDTO getCategory(Long categoryId) {
	  Category category = categoryRepository.findById(categoryId).orElseThrow
							(()-> new ResourceNotFoundException("Category","id",categoryId));
		
		return modelMapper.map(category, CategoryDTO.class);
	}


	@Override
	public List<CategoryDTO> getAllCategories() {
				List<Category> catlist=categoryRepository.findAll();
		return catlist.stream().map((category)->modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
	}


	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Long catId) {
		Category category=categoryRepository.findById(catId).orElseThrow(()->
		new ResourceNotFoundException("Category","id",catId));
		
		category.setCatName(categoryDto.getCatName());
		category.setDescription(categoryDto.getDescription());
		category.setCatId(catId);
		
		Category saveCategory=categoryRepository.save(category);
		return modelMapper.map(saveCategory, CategoryDTO.class);
	}


	@Override
	public String deleteCategory(Long catId) {
		Category category=categoryRepository.findById(catId).orElseThrow(()->
		new ResourceNotFoundException("Category","id",catId));
		
		categoryRepository.delete(category);
		return "Deleted successfully...";
		
	}

}
