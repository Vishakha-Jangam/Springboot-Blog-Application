package com.masai.springboot_blogApp.exception;

import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException{

	private HttpStatus httpStatus;
	private String message;
	
    public BlogApiException(HttpStatus httpStatus, String message) {	
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	
	public BlogApiException(HttpStatus httpStatus, String message, String message2) {
		super(message2);
		this.httpStatus = httpStatus;
		this.message = message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public String getMessage() {
		return message;
	}
	
	
}
