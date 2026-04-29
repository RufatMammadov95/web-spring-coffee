package com.example.webspringcoffee.singleton;

import com.example.webspringcoffee.service.CoffeeService;

public class ServiceSingleton {

	private static CoffeeService instance;

	public static CoffeeService getInstance(CoffeeService service) {
		if (instance == null) {
			instance = service;
		}
		return instance;
	}
}