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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Order;
import com.data.entity.Product;
import com.data.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins="http://localhost:4200/")
public class OrderController {
@Autowired
private OrderService ors;
@GetMapping("/findorders")
 public List<Order> findall() {
	   return ors.findallorder();
 }
@PostMapping("/addorder")
  public Order addproduct(@RequestBody Order o)
  {
	   return ors.addorder(o);
  }

 @DeleteMapping("/deletebyid/{id}")
  public ResponseEntity<Map<String,String>> deletebyid(@PathVariable("id") int id){
	   Map<String ,String>Response=new HashMap<>();
	   ors.deletebyid(id);
	   Response.put("message", "Record deleted sucessfully");
	   return ResponseEntity.ok(Response);

}
 
 @PutMapping("/update/{id}")
	public ResponseEntity<Map<String,String>> update(@PathVariable("id") int id, @RequestBody Order o) {
		Map<String,String> Response=new HashMap<>();
		ors.update(id, o);
		Response.put("message","Record updated successfully");
		return ResponseEntity.ok(Response);
	}
}

