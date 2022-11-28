package com.masai.springboot_blogApp.repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.springboot_blogApp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	List<Post> findByUploadDateBetween (LocalDateTime startDate, LocalDateTime endDate);


}
