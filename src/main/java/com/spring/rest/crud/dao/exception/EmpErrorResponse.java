package com.spring.rest.crud.dao.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpErrorResponse {

	private HttpStatus status;
	private String message;

	public void setStatus(int value) {

	}

}