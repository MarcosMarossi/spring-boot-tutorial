package com.course.services.exception;

public class ResourceNotFountException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFountException(Object id) {
		super("Resource not found. Id " + id);
	}

}
