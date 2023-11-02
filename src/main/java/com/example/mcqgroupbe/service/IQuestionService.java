package com.example.mcqgroupbe.service;

import java.util.List;

import com.example.mcqgroupbe.entity.Question;

public interface IQuestionService {
	List<Question> getQuestionbyTopicAndSetId(int topicId, int setId);
	List<Question> getQuestionbyTopicId(int topicId);

}
