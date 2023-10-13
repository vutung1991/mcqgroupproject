package com.example.mcqgroupbe.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

@GetMapping("/abc")
@PreAuthorize("hasAuthority('USER')")
public String abc() {
	
	return "Hi";
}
}
