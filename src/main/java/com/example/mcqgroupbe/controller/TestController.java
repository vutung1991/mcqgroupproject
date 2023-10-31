package com.example.mcqgroupbe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

@GetMapping("/abc")

public ResponseEntity<Object> abc() {
	
	return ResponseEntity.ok().build();
}
@RequestMapping("/a")
@CrossOrigin(origins="*", maxAge=3600)
public String home() {
  return new String("Hello World");
}
}
