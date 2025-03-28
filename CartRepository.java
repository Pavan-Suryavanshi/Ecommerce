package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
