package com.example.mcqgroupbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.User;
import com.example.mcqgroupbe.entity.UserContactDetails;
import com.example.mcqgroupbe.repository.UserDetailsRepository;
import com.example.mcqgroupbe.repository.security.UserRepository;
@Service
public class SecurityUserDetailsService implements UserDetailsService {
	@Autowired 
	   private UserRepository userRepository; 
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	   
	   
	   public UserContactDetails createUser(User user) { 
		   UserContactDetails userContactDetails = new UserContactDetails();
		   userContactDetails.setUser(userRepository.save((User) user));
		   userContactDetails.setEmail(user.getEmail());
		   userContactDetails.setFirstName(user.getFirstName());
		   userContactDetails.setLastName(user.getLastName());
		   return userDetailsRepository.save(userContactDetails);
	   } 
	   public UserContactDetails editUser(User user) { 
		   UserContactDetails userContactDetails = userDetailsRepository.findById(user.getUserId()).get();
		   userContactDetails.setUser(userRepository.save((User) user));
		   userContactDetails.setEmail(user.getEmail());
		   userContactDetails.setFirstName(user.getFirstName());
		   userContactDetails.setLastName(user.getLastName());
		   return userDetailsRepository.save(userContactDetails);
	   } 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findUserByUsername(username) 
		         .orElseThrow(() -> new UsernameNotFoundException("User not present")); 
		System.out.println(user.getRole());
		         return user; 
	}

}
