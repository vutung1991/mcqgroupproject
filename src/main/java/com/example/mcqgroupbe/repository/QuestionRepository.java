package com.example.mcqgroupbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mcqgroupbe.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
//    List<Question> findBySetId(int setId);
//    List<Question> findByCorrectAnswer(int correctAnswer);
//    List<Question> findBySetIdAndCorrectAnswer(int setId, int correctAnswer);
//    List<Question> findByQuestion(String question);

}

