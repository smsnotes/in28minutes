package com.in28minutes.rest.webservices.restfullwebservices.helloworld;

public class HelloWorldBean  {
	
	private String message ;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public HelloWorldBean(String msg) {
		this.message = msg;
	}
	
	@Override
	public String toString () {
			return String.format("HelloWorldBean:[message=%s]",this.message);
	}
	
}
