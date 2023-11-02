package com.example.mcqgroupbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.Question;
import com.example.mcqgroupbe.repository.security.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService {
	
	@Autowired
	IQuestionRepository questionRepository;

	@Override
	public List<Question> getQuestionbyTopicAndSetId(int topicId, int setId) {
		return questionRepository.getQuestionbyTopicAndSetId(topicId, setId);
	}

	@Override
	public List<Question> getQuestionbyTopicId(int topicId) {
		// TODO Auto-generated method stub
		return questionRepository.getQuestionbyTopicId(topicId);
	}
}
