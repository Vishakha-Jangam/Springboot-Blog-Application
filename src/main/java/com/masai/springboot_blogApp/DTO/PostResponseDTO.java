package com.masai.springboot_blogApp.DTO;

import java.util.List;

public class PostResponseDTO {

	private List<PostDTO> content;
	private Integer pageNo;
	private Integer PageSize;
	private Long totalElements;
	private Integer totalPages;
	private boolean last;
	public PostResponseDTO() {
		super();
		
	}
	public PostResponseDTO(List<PostDTO> content, Integer pageNo, Integer pageSize, Long totalElements,
			Integer totalPages, boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		PageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	public List<PostDTO> getContent() {
		return content;
	}
	public void setContent(List<PostDTO> content) {
		this.content = content;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return PageSize;
	}
	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
}
