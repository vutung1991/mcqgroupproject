package com.example.mcqgroupbe.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.entity.UserContactDetails;

import jakarta.persistence.EntityManager;

@Repository
public class UserJoinRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<User> getUsers(){
		Session currSession =entityManager.unwrap(Session.class);
		String hql = "from User as user inner join UserContactDetails as usc";

		List<?> list = currSession.createQuery(hql).list();

		for(int i=0; i<list.size(); i++) {
		    Object[] row = (Object[]) list.get(i);
		    User subject= (User )row[0];
		    System.out.println(subject.getUserId()+" "+ subject.toString());
		    UserContactDetails employee = (UserContactDetails)row[1];
		    System.out.println(employee.getUserId() +" " +employee.toString());
		}  
		return null;
	}
}
