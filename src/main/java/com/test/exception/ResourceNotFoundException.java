package com.test.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiExeption {

//	public ResourceNotFoundException(HttpStatus status, String message) {
//		super(status, message);
//		// TODO Auto-generated constructor stub
//	}
	
	public ResourceNotFoundException(String resourceName,int id) {
		super(HttpStatus.NOT_FOUND,String.format("%s with id=%d not found",resourceName,id));
	}

	}
