package com.example.mcqgroupbe.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.entity.UserContactDetails;
import com.example.mcqgroupbe.service.SecurityUserDetailsService;

@RestController
public class SecurityController {
	
	
	@Autowired
	private SecurityUserDetailsService userDetailsManager; 

	@Autowired
	   private PasswordEncoder passwordEncoder;
	@PostMapping("/register")
	public String addUser(@RequestBody User user) {
		System.out.println("SuperUser");
	    System.out.println(user.getUsername());  
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    
		userDetailsManager.createUser(user);
		return "hi";
	   }
	@PreAuthorize("hasAuthority('SU')")
	@PostMapping("/createAdmin")
	public UserContactDetails createAdmmin(@RequestBody User user) {
		System.out.println("Hi");
	    System.out.println(user.getUsername());  
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRole("ADMIN");
		return userDetailsManager.createUser(user);
		
	   }
	@PreAuthorize("hasAuthority('SU')")
	@PostMapping("/editAdmin")
	public UserContactDetails editAdmmin(@RequestBody User user) {
		System.out.println("Hi");
	    System.out.println(user.getUsername());  
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRole("ADMIN");
		return userDetailsManager.editUser(user);
		
	   }
	
	@PreAuthorize("hasAnyAuthority('ADMIN','SU')")
	@PostMapping("/createUser")
	public UserContactDetails createUser(@RequestBody User user) {
		System.out.println("Hi");
	    System.out.println(user.getUsername());  
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRole("USER");
		return userDetailsManager.createUser(user);
	   }
	
	@CrossOrigin(origins="http://localhost:4200/")
	@RequestMapping("/user")
	  public Principal user(Principal user) {
		System.out.println(user.toString());
	    return user;
	  }
	@CrossOrigin(origins="http://localhost:4200/")
	@RequestMapping("/login")
	  public Principal login(Principal user) {
		System.out.println(user.toString());
	    return user;
	  }
	
	@CrossOrigin(origins="http://localhost:4200/")
	@RequestMapping("/")
	  public Principal home(Principal user) {
		System.out.println(user.toString());
	    return user;
	  }
	
	
	
}
