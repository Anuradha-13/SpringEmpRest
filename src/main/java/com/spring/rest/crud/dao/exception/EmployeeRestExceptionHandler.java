package com.spring.rest.crud.dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	    @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity employeeNotFoundExceptionHandler(EmployeeNotFoundException exception) {
	    	EmpErrorResponse errResp= new EmpErrorResponse();
	    	errResp.setStatus(HttpStatus.NOT_FOUND.value());
	    	errResp.setMessage(exception.getMessage());
	          return new ResponseEntity<>(errResp,HttpStatus.NOT_FOUND);
	    }
	
}
