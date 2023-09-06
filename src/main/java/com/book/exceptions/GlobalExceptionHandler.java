package com.book.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserDetailsNotFoundException exception,HttpServletRequest request)
	{
		ApiError error=new ApiError();
		error.setMessage(exception.getMessage());;
		error.setLocalDateTime(LocalDateTime.now());
		error.setEndpoint(request.getRequestURI());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(error, error.getHttpStatus());
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException exception,HttpServletRequest request)
	{
		ApiError error=new ApiError();
		error.setMessage(exception.getMessage());;
		error.setLocalDateTime(LocalDateTime.now());
		error.setEndpoint(request.getRequestURI());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(error, error.getHttpStatus());
	}
	
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<?> handleReviewNotFoundException(ReviewNotFoundException exception,HttpServletRequest request)
	{
		ApiError error=new ApiError();
		error.setMessage(exception.getMessage());;
		error.setLocalDateTime(LocalDateTime.now());
		error.setEndpoint(request.getRequestURI());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(error, error.getHttpStatus());
	}


}
