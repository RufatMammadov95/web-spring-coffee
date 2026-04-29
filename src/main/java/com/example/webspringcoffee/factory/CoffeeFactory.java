package com.example.webspringcoffee.factory;

import com.example.webspringcoffee.model.Order;

public class CoffeeFactory {

	public static Order createCoffee(String type) {

		switch (type.toLowerCase()) {
		case "espresso":
			return new Order("Espresso", "PENDING");

		case "latte":
			return new Order("Latte", "PENDING");

		case "cappuccino":
			return new Order("Cappuccino", "PENDING");

		default:
			throw new IllegalArgumentException("Unknown coffee type");
		}
	}
}
