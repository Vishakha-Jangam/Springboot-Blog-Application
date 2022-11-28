package com.masai.springboot_blogApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private Long fieldvalue;
	private String fieldString;
	
	public ResourceNotFoundException() {
		
	}
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldvalue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
		
	}
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldString) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldString));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldString = fieldString;
		
	}

	public String getResourceName() {
		return resourceName;
	}

	
	public String getFieldName() {
		return fieldName;
	}

	
	public Long getFieldvalue() {
		return fieldvalue;
	}

	
	public String getFieldString() {
		return fieldString;
	}

	

}
