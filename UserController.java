package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.dto.LoginRequest;
import com.data.entity.User;
import com.data.service.authservice;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
    private authservice authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }

//    @PostMapping("/login")
//    public User login(@RequestParam String username, @RequestParam String password) {
//        return authService.login(username, password);
//    }
    
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginRequest request){
    	User user = authService.login(request.getUsername(), request.getPassword());
    	
    	if(user != null)
    	{
    		return ResponseEntity.ok(user);
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
    				.body("Invalid username or password");
    	}
    }

}
