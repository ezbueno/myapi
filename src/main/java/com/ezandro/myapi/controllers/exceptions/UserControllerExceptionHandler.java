package com.ezandro.myapi.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ezandro.myapi.services.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserControllerExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandardError> userNotFound(UserNotFoundException u, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), u.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
