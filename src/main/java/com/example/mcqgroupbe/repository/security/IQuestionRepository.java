package com.example.mcqgroupbe.repository.security;

import java.util.List;

import com.example.mcqgroupbe.entity.Question;

public interface IQuestionRepository {
	
	List<Question> getQuestionbyTopicAndSetId(int topicId,int setId);
	List<Question> getQuestionbyTopicId(int topicId);
}
