package com.masai.springboot_blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
