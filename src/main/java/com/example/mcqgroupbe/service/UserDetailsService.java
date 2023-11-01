package com.example.mcqgroupbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.UserContactDetails;
import com.example.mcqgroupbe.model.UserModel;
import com.example.mcqgroupbe.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public UserModel getuser(long userId){
		UserModel user = new UserModel(); 
		UserContactDetails userC = userDetailsRepository.findUserByUserId(userId).get();
		user.setEmail(userC.getEmail());
		user.setFirstName(userC.getFirstName());
		user.setLastName(userC.getLastName());
		user.setUserId(userId);
		return user;
	}
	
}
