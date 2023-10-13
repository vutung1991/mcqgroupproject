package com.example.mcqgroupbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.repository.security.UserRepository;
@Service
public class SecurityUserDetailsService implements UserDetailsService {
	@Autowired 
	   private UserRepository userRepository; 
	   
	   
	   public void createUser(UserDetails user) { 
	      userRepository.save((User) user); 
	   } 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findUserByUsername(username) 
		         .orElseThrow(() -> new UsernameNotFoundException("User not present")); 
		         return user; 
	}

}
