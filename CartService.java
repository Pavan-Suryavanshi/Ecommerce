package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.Cart;
import com.data.entity.CartItem;
import com.data.repository.CartItemRepository;
import com.data.repository.CartRepository;



@Service
public class CartService {
	@Autowired
	CartRepository cartresp;
	
	@Autowired
	private  CartItemRepository cartItemRepository;
	
	
	public Cart createCart() {
		Cart cart=new Cart();
		cart.setTotalPrice(0.0);
		return cartresp.save(cart);
	}
	 
	   
	    

	    // Add item to cart
	    public Cart addItemToCart(Long cartId, CartItem cartItem) {
	    	 Cart cart = cartresp.findById(cartId).orElse(null);

	    	    // Add the item to the cart's item list
	    	    cartItem.setCart(cart);
	    	    cart.getItems().add(cartItem);
	    	    

	    	    // Update the total price
	    	    cart.setTotalPrice(cart.getTotalPrice() + (cartItem.getPrice() * cartItem.getQuantity()));

	    	    // Save the cart (it will cascade save CartItem as well)
	    	    return cartresp.save(cart);
	        }


	    // Get all items in a cart
	    public List<CartItem> getCartItems(int cartId) {
	        return cartItemRepository.findByCartId(cartId);
	    }

	    // Remove item from cart
	    public String removeCartItem(Long itemId) {
	    	 CartItem cartItem =  cartItemRepository.findById(itemId)
	                 .orElse(null);
	               
	        Cart cart = cartItem.getCart();
	        cart.setTotalPrice(cart.getTotalPrice() - (cartItem.getPrice() * cartItem.getQuantity()));
	        cartItemRepository.deleteById(itemId);
	        cartresp.save(cart);
	        return "Cart Item renoved from cart";
	    }

	}