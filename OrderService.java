package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.data.entity.Order;
import com.data.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository or;

	@PostMapping("/addorder")
	public Order addorder(@RequestBody Order o) {
		return or.save(o);
	}

	public List<Order> findallorder() {
		return or.findAll();
	}

	public Order findbyid(int id) {
		return or.findById(id).orElse(null);
	}

	public String deletebyid(int id) {
		or.deleteById(id);
		return "Order deleted sucessfully";

	}
	
	public String update(int id,Order o) {
		Order existing=or.findById(id).orElse(null);
		if(existing !=null) {
			if(o!=null) {
				if(o.getProductName()!=null) {
					existing.setProductName(o.getProductName());
				}
				if(o.getPrice()!=0) {
					existing.setPrice(o.getPrice());
					
				}
				if(o.getQuantity()!=0) {
					existing.setId(o.getQuantity());
				}
				or.save(existing);
				return "Record updated successfully";
				
			}
			return "No updated data updation not performed";
			
		}
		return "record not found";
		
	}
	
	
	
	
}
