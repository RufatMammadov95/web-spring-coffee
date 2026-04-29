package com.example.webspringcoffee.service;

import com.example.webspringcoffee.model.Order;
import com.example.webspringcoffee.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final OrderRepository orderRepository;

    public CoffeeService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(String coffeeType) {
        Order order = new Order(coffeeType, "PENDING");
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}