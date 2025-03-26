package com.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.data.entity.User;
import com.data.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class authservice {
	
	 @Autowired
	    private UserRepository userRepository;

	    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	    @Transactional
	    public String registerUser(User user) {
	       
	            if (!user.getRole().equalsIgnoreCase("ADMIN") && 
	                !user.getRole().equalsIgnoreCase("CUSTOMER")) {
	                return "Invalid role";
	            }

	            if (userRepository.findByUsername(user.getUsername()).isPresent()) {
	                return "Username already exists";
	            }

	            user.setPassword(passwordEncoder.encode(user.getPassword()));
	            userRepository.save(user);

	            return "User Registered Successfully";
	        } 
	    

	    public User login(String username, String password) {
	        User user = userRepository.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!passwordEncoder.matches(password, user.getPassword())) {
	            throw new RuntimeException("Invalid Credentials");
	        }

	        return user;
	    }

}
