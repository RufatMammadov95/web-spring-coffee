package com.example.webspringcoffee.strategy;

public class EspressoStrategy implements CoffeeStrategy {
	public double calculatePrice() {
		return 3.0;
	}
}