package com.example.mcqgroupbe.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mcqgroupbe.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	 Optional<User> findUserByUsername(String username); 
	 Optional<User> findUserByUserId(long userId); 
}	
