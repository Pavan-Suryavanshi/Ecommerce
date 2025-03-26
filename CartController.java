package com.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Cart;
import com.data.entity.CartItem;
import com.data.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200") // Allow
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/addcart")
	public Cart createCart() {
		return cartService.createCart();
	}

// Add item to cart
	@PostMapping("/items/{cartId}")
	public Cart addItemToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
		return cartService.addItemToCart(cartId, cartItem);
	}

// Get all items in a cart
	@GetMapping("/items/")
	public List<CartItem> getCartItems(@PathVariable int cartId) {
		return cartService.getCartItems(cartId);
	}

	// Remove item from cart
	/*@DeleteMapping("/items/{itemId}")
	public String removeCartItem(@PathVariable Long itemId) {
		return cartService.removeCartItem(itemId);

	}*/
	
	// Remove item from cart
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Map<String,String>> removeCartItem(@PathVariable long itemId) {
        cartService.removeCartItem(itemId);
        Map<String,String> response=new HashMap<>();
        response.put("message","Record deleted sucessfully");
        return ResponseEntity.ok(response);
        
        
    }

}
