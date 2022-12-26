package com.masai.springboot_blogApp.exception;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.masai.springboot_blogApp.DTO.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handle specific exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> ResourceNotFoundHandler(ResourceNotFoundException rnfe,
																WebRequest webRequest){
	    ErrorDetails error =new ErrorDetails(new Date(), rnfe.getMessage(), webRequest.getDescription(false));
	    return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BlogApiException.class)
	public ResponseEntity<ErrorDetails> BlogApiExceptionHandler(BlogApiException bapie,
																WebRequest webRequest){
	    ErrorDetails error =new ErrorDetails(new Date(), bapie.getMessage(), webRequest.getDescription(false));
	    return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	//global exceptions
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception exception,
																WebRequest webRequest){
	    ErrorDetails error =new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
	    return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException manve,
																		 WebRequest webRequest){
		Map<String, String> errors = new HashMap<>();
		manve.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName =((FieldError) error).getField();
			String message =error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> AccessDeniedExceptionHandler(AccessDeniedException exception,
																WebRequest webRequest){
	    ErrorDetails error =new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
	    return new ResponseEntity<ErrorDetails>(error,HttpStatus.UNAUTHORIZED);
	}
}
