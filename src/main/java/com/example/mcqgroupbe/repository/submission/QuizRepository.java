package com.example.mcqgroupbe.repository.submission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mcqgroupbe.submission.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
	List<Quiz> findActiveQuizzesByTopicId(@Param("topicId") Long topicId);
}