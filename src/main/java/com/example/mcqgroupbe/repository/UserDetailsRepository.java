package com.example.mcqgroupbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mcqgroupbe.entity.UserContactDetails;

public interface UserDetailsRepository  extends JpaRepository<UserContactDetails, Long>{

}
