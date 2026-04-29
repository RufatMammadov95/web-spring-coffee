package com.example.webspringcoffee.service;

import com.example.webspringcoffee.factory.CoffeeFactory;
import com.example.webspringcoffee.model.Order;
import com.example.webspringcoffee.observer.OrderStatusNotifier;
import com.example.webspringcoffee.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class CoffeeService {

	private final OrderRepository orderRepository;
	private final OrderStatusNotifier notifier;

	private final ReentrantLock lock = new ReentrantLock();

	public CoffeeService(OrderRepository orderRepository, OrderStatusNotifier notifier) {
		this.orderRepository = orderRepository;
		this.notifier = notifier;
	}

	@Transactional
	public Order placeOrder(String coffeeType) {

		lock.lock();
		try {
			Order order = CoffeeFactory.createCoffee(coffeeType);

			Order saved = orderRepository.save(order);

			notifier.notifyAllObservers("ORDER CREATED: " + saved.getCoffeeType());

			return saved;

		} finally {
			lock.unlock();
		}
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public void registerObserver(String name) {
		notifier.addObserver(status -> {
			System.out.println(name + " received: " + status);
		});
	}
}