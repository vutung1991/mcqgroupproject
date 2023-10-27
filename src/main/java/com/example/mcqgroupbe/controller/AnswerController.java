package com.example.mcqgroupbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.Answer;
import com.example.mcqgroupbe.repository.AnswerRepository;

@RestController
@RequestMapping("/answers")
public class AnswerController {

	private final AnswerRepository answerRepository;

	@Autowired
	public AnswerController(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;

	}

	// get All employees
	@GetMapping("/answers")
	public List<Answer> getAllQuestions() {
		return answerRepository.findAll();

	}
	
	
	
	

}
