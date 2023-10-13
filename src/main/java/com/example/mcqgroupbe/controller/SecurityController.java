package com.example.mcqgroupbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.service.SecurityUserDetailsService;

@RestController
public class SecurityController {
	
	
	@Autowired
	private SecurityUserDetailsService userDetailsManager; 

	@Autowired
	   private PasswordEncoder passwordEncoder;
	@PostMapping("/register")
	public String addUser(@RequestBody User user) {
		System.out.println("Hi");
	    System.out.println(user.getUsername());  
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDetailsManager.createUser(user);
		return "hi";
	   }
}
