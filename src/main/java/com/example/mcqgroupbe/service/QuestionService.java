package com.example.mcqgroupbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.Question2;
import com.example.mcqgroupbe.repository.security.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService {
	
	@Autowired
	IQuestionRepository questionRepository;

	public Question2 createQuestion(Question2 question){
		return questionRepository.createQuestion(question);
	}
}
