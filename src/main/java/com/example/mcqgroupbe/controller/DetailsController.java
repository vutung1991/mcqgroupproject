package com.example.mcqgroupbe.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.entity.UserContactDetails;
import com.example.mcqgroupbe.repository.UserDetailsRepository;
import com.example.mcqgroupbe.repository.UserJoinRepository;
import com.example.mcqgroupbe.repository.security.UserRepository;

@RestController
public class DetailsController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	UserJoinRepository joinRepository;
	
	@GetMapping("/get/{userId}")
	Optional<User> getUser(@PathVariable long userId) {
		return userRepository.findById(userId);
	}
	
	@GetMapping("/getUsers")
	List<UserContactDetails> getAllUsers(){
		return userDetailsRepository.findAll()
				.stream()
				.filter(u -> u.getUser().getRole().equals("USER"))
				.collect(Collectors.toList());
	}
	@GetMapping("/getAdmins")
	List<UserContactDetails> getAllAdmins(){
		return userDetailsRepository.findAll()
				.stream()
				.filter(u -> u.getUser().getRole().equals("ADMIN"))
				.collect(Collectors.toList());
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping("/delete/{userId}")
	void deleteUser(@PathVariable long userId) {
		userDetailsRepository.deleteById(userId);
	}
	
}
