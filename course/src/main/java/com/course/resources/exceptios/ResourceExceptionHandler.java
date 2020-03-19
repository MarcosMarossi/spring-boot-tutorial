package com.course.resources.exceptios;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.course.services.exception.DatabaseException;
import com.course.services.exception.ResourceNotFountException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFountException.class)
	public ResponseEntity<StandardError> resourceNotFound (ResourceNotFountException e, HttpServletRequest request){
		String msn = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(), status.value() , msn, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database (DatabaseException e, HttpServletRequest request){
		String msn = "Database error";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(), status.value() , msn, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);		
	}
}
