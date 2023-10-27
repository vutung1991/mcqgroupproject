package com.example.mcqgroupbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mcqgroupbe.entity.Submission;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    
	List<Submission> findAllByUserId(int userId);
}