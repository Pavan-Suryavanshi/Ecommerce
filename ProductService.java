package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.Product;
import com.data.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public Product addproduct(Product p) {
		return pr.save(p);
	}
	
	public List<Product> findallprod(){
		return pr.findAll();
	}
	
	public Product findById(int id) {
		return pr.findById(id).orElse(null);
	}
	
	public Product findbyname(String name) {
		return pr.findByName(name);
	}
	
	public String deletebyid(int id) {
		pr.deleteById(id);
		return "Product deleted successfully";
	}
	
	public String update(int pid,Product newp) {
		Product existingProduct=pr.findById(pid).orElse(null);
		if(existingProduct!=null) {
			if(newp!=null) {
				if(newp.getName()!=null) {
					existingProduct.setName(newp.getName());
				}
				if(newp.getPrice()!=0) {
					existingProduct.setPrice(newp.getPrice());
				}
				if(newp.getStock()!=0) {
					existingProduct.setStock(newp.getStock());
				}
				if(newp.getDescription()!=null) {
					existingProduct.setDescription(newp.getDescription());
				}
				if(newp.getImg()!=null) {
					existingProduct.setDescription(newp.getDescription());
				}
				pr.save(existingProduct);
				return "Product details updated successfully";
			}
			return " No any details of Product changed";
		}
		return "Product not found";
	}

}
