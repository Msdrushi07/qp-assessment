package com.grocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity<ExcptionResponse> handlingNotFoundException(NotFoundException exception){
		ExcptionResponse er = new ExcptionResponse(HttpStatus.NOT_FOUND,exception.getMessage());
		return new ResponseEntity<ExcptionResponse>(er,HttpStatus.NOT_FOUND);
	}

}
