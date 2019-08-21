package com.in28minutes.rest.webservices.restfullwebservices.work;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WorkerNotFoundException(String message) {
		super(message);
	}
	
	

}
