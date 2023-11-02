package com.example.mcqgroupbe.service.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.repository.submission.QuizRepository;
import com.example.mcqgroupbe.submission.entity.Quiz;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
    public List<Quiz> getActiveQuizzes(Long topicId) {
        return quizRepository.findActiveQuizzesByTopicId(topicId);
    }
}
