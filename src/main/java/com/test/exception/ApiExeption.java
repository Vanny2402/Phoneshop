package com.test.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiExeption extends RuntimeException{
	private	final HttpStatus status;
	private	final String message;
	

	
}
