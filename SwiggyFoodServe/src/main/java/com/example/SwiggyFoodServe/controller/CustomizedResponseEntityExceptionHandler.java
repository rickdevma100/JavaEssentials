package com.example.SwiggyFoodServe.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RestaurantNotFoundException.class)
	public final ResponseEntity<Object> handleExceptionCustom(Exception ex, WebRequest request){
			
		ErrorMessage error=new ErrorMessage(new Date(),ex.getMessage(), request.getDescription(false)); 
		return  new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleOrderExceptionCustom(Exception ex, WebRequest request){
			
		ErrorMessage error=new ErrorMessage(new Date(),ex.getMessage(), request.getDescription(false)); 
		return  new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
		
	}
}
