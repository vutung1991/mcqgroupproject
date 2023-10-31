package com.example.mcqgroupbe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.repository.security.UserRepository;

@RestController
public class DetailsController {

	@Autowired
	UserRepository userRepository;
	@GetMapping("/get/{userId}")
	Optional<User> getUser(@PathVariable long userId) {
		return userRepository.findById(userId);
	}
}
