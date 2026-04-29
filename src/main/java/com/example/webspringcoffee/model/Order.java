package com.example.webspringcoffee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Coffee type cannot be empty")
	@Column(nullable = false)
	private String coffeeType;

	@Column(nullable = false)
	private String status;

	public Order() {
		this.status = "PENDING";
	}

	public Order(String coffeeType) {
		this.coffeeType = coffeeType;
		this.status = "PENDING";
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
