package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public Product findByPrice(double price);
	public Product findByName(String name);

}
