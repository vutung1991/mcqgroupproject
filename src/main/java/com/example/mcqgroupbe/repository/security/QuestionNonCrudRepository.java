package com.example.mcqgroupbe.repository.security;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etr.MedicalProject.entity.user.User;
import com.example.mcqgroupbe.entity.Question;

import jakarta.persistence.EntityManager;
@Repository
public class QuestionNonCrudRepository implements IQuestionRepository{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Question> getQuestionbyTopicAndSetId(int topicId, int setId) {
		Session currSession =entityManager.unwrap(Session.class);
//		String query = "FROM User u WHERE u.apptNum = :apptname AND u.id = :userId";
//        return (User) session.createQuery(query)
//                .setParameter("apptname", apptname)
//                .setParameter("userId", userId)
//                .uniqueResult()
		Query <Question> query = currSession.createQuery("from Question where setId =:setId and topicId =:topicId ",Question.class)
				.setParameter("setId",setId)
				.setParameter("topicId", topicId);
		
		List<Question> list = query.getResultList();
		if(list.size()>0)
		return list;
		return null;
	}
	

}
