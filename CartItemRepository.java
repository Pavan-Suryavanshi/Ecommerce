package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
        List<CartItem> findByCartId(int cartId);
}
