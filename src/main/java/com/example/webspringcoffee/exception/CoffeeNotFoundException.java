package com.example.webspringcoffee.exception;

public class CoffeeNotFoundException extends RuntimeException {

	public CoffeeNotFoundException(String message) {
		super(message);
	}
}