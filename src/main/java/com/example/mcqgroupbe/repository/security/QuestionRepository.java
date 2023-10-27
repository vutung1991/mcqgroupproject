package com.example.mcqgroupbe.repository.security;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mcqgroupbe.entity.Question2;

import jakarta.persistence.EntityManager;
@Repository
public class QuestionRepository implements IQuestionRepository{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Question2 createQuestion(Question2 question) {
		Session currSession =entityManager.unwrap(Session.class);
		int id = (int) currSession.save(question);
		return currSession.get(Question2.class,id);
	}

}
