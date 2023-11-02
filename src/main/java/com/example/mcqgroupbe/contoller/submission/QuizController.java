package com.example.mcqgroupbe.contoller.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.service.submission.QuizService;
import com.example.mcqgroupbe.service.submission.SubmissionService;
import com.example.mcqgroupbe.submission.entity.Quiz;
import com.example.mcqgroupbe.submission.entity.Submission;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private SubmissionService submissionService;
    
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(@RequestParam Long topicId) {
        return quizService.getActiveQuizzes(topicId);
    }

    @PostMapping("/submit")
    public Submission submitQuiz(@RequestBody Submission submission) {
        return submissionService.submitQuiz(submission);
    }
    
    @GetMapping("/all")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
    
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
}
    @PutMapping("/update/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz updatedQuiz) {
        Quiz existingQuiz = quizService.getQuizById(quizId);
        if (existingQuiz == null) {
            return ResponseEntity.notFound().build();
        }

        existingQuiz.setTitle(updatedQuiz.getTitle());
        existingQuiz.setTopicId(updatedQuiz.getTopicId());
        existingQuiz.setActive(updatedQuiz.isActive());

        quizService.updateQuiz(existingQuiz);

        return ResponseEntity.ok(existingQuiz);
    }

}