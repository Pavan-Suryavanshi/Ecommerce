package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
