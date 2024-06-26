package com.test.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHadler { 
	@ExceptionHandler(ApiExeption.class)
	
	public ResponseEntity<?> handleAPIException(ApiExeption e){
		ErrorRespond errorRespond=new ErrorRespond(e.getStatus(), e.getMessage());
		return ResponseEntity
				.status(e.getStatus())
				.body(errorRespond);
	}

}
