package com.data.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int quantity;
	private LocalDateTime orderDate;
	private double price;
	public Order() {
		super();
		this.setOrderDateTime(LocalDateTime.now());
	}
	
	public Order(int id, String productName, int quantity, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDateTime(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
