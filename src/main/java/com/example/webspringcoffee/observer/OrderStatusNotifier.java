package com.example.webspringcoffee.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class OrderStatusNotifier {

	private final List<Consumer<String>> observers = new ArrayList<>();

	public void addObserver(Consumer<String> observer) {
		observers.add(observer);
	}

	public void notifyAllObservers(String status) {
		for (Consumer<String> o : observers) {
			o.accept(status);
		}
	}
}