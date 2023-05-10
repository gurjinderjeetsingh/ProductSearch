package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.ServiceError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleError(ProductNotFoundException ex) {
		 
		ServiceError error=new ServiceError("satus", "message");
		
		//ServiceError error=new ServiceError("ProductNotFoundException", ex.getMessage());
        
		//	return "hello";	
		return new ResponseEntity<String>("Hello",HttpStatus.NOT_FOUND);
	}
}
