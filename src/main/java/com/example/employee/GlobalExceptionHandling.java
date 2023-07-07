package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFoundExceptionHandling(NameNotFoundException ne) {
		return new ResponseEntity<>(ne.getMessage(), HttpStatus.NOT_FOUND);
	}

}
