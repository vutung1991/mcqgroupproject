package com.example.mcqgroupbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mcqgroupbe.submission.entity.Submission;

import java.util.List;

public interface SubmissionRepository2 extends JpaRepository<Submission, Integer> {
    
	List<Submission> findAllByUserId(int userId);
}