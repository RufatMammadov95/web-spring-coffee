package com.example.webspringcoffee.controller;

import com.example.webspringcoffee.model.Order;
import com.example.webspringcoffee.service.CoffeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoffeeController {

	private final CoffeeService coffeeService;

	public CoffeeController(CoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/order")
	public String placeOrder(@RequestParam String coffeeType) {
		coffeeService.placeOrder(coffeeType);
		return "redirect:/orders";
	}

	@GetMapping("/orders")
	public String orders(Model model) {
		List<Order> orders = coffeeService.getAllOrders();
		model.addAttribute("orders", orders);
		return "orders";
	}
}