package com.example.webspringcoffee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String coffeeType;
	private String status;

	public Order() {
	}

	public Order(String coffeeType, String status) {
		this.coffeeType = coffeeType;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
