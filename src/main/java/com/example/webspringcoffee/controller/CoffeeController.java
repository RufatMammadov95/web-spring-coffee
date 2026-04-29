package com.example.webspringcoffee.controller;

import com.example.webspringcoffee.model.Order;
import com.example.webspringcoffee.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoffeeController {

	private final CoffeeService coffeeService;

	public CoffeeController(CoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("order", new Order());
		return "index";
	}

	@PostMapping("/order")
	public String placeOrder(@Valid @ModelAttribute("order") Order order, BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}

		coffeeService.placeOrder(order.getCoffeeType());
		return "redirect:/orders";
	}

	@GetMapping("/orders")
	public String orders(Model model) {
		List<Order> orders = coffeeService.getAllOrders();
		model.addAttribute("orders", orders);
		return "orders";
	}

	@GetMapping("/chat")
	public String chatPage() {
		return "chat";
	}
}