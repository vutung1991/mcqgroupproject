package com.example.mcqgroupbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.Question2;
import com.example.mcqgroupbe.service.IQuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController2 {
	
	@Autowired
	IQuestionService questionService;
	
	@PostMapping("/create")
	Question2 createQuestion(@RequestBody Question2 question) {
		System.out.println(question.toString());
		return questionService.createQuestion(question);
	}
	

}
