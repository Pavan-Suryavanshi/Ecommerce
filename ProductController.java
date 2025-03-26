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

import com.data.entity.Product;
import com.data.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/getall")
	public List<Product> findall(){
		return ps.findallprod();
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product p) {
		return ps.addproduct(p);
	}
	
	@GetMapping("/findbyid/{id}")
	public Product findById(@PathVariable("id") int pid) {
		return ps.findById(pid);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Map<String,String>> deletebyid(@PathVariable("id") int pid) {
		Map<String,String> Response=new HashMap<>();
		ps.deletebyid(pid);
		Response.put("message","Product details deleted successfully");
		return ResponseEntity.ok(Response);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String,String>> update(@PathVariable("id") int pid, @RequestBody Product P) {
		Map<String,String> Response=new HashMap<>();
		ps.update(pid, P);
		Response.put("message","Record updated successfully");
		return ResponseEntity.ok(Response);
	}
	
	
	

}
