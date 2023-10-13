package com.example.mcqgroupbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

@GetMapping("/abc")
public String abc() {
	
	return "Hi";
}
}
