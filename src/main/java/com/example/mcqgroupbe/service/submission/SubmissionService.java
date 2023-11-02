package com.example.mcqgroupbe.service.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mcqgroupbe.repository.submission.SubmissionRepository;
import com.example.mcqgroupbe.submission.entity.Answer2;
import com.example.mcqgroupbe.submission.entity.Submission2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SubmissionService {
    private static final Logger logger = LoggerFactory.getLogger(SubmissionService.class);

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private EmailService emailService;

    public Submission2 createSubmission(Submission2 submission) {
        if (submission.getId() == null) {
            long newSubmissionId = generateDynamicSubmissionId(submission.getUserId());
            submission.setId(newSubmissionId);
        }
        submission = submissionRepository.save(submission);
        return submission;
    }


    public Submission2 getSubmissionByUserIdAndSetId(Long userId, int setId) {
        return submissionRepository.findByUserIdAndSetId(userId, setId);
    }

    private Long generateDynamicSubmissionId(Long userId) {
        long timestamp = System.currentTimeMillis();
        return userId * 1000000 + timestamp;
    }
    
    public void calculateAndSetScore(Submission2 submission) {
        List<Answer2> answers = submission.getAnswers();

        if (answers != null) {
            int correctAnswers = 0;

            for (Answer2 answer : answers) {
                if (answer.isCorrect()) {
                    correctAnswers++;
                }
            }

            submission.setScore(correctAnswers);
            submissionRepository.save(submission);

            sendScoreEmailToAdmin(submission.getUserId(), submission.getScore());
        } else {
            logger.error("Questions are not answered in the submission with ID: " + submission.getId());
        }
    }

    public void sendScoreEmailToAdmin(long userId, long score) {
        String adminEmail = "arik.bhar9999@gmail.com";
        String subject = "User Score Notification";
        String message = "User with ID " + userId + " scored " + score + " in the MCQ test.";

        emailService.sendSimpleEmail(adminEmail, subject, message);
    }
    public Submission2 submitQuiz(Submission2 submission) {
        
        if (submission.getId() == null) {
            long newSubmissionId = generateDynamicSubmissionId(submission.getUserId());
            submission.setId(newSubmissionId);
        }
        
        submission = submissionRepository.save(submission);

        
        calculateAndSetScore(submission);

        return submission;
    }
}
