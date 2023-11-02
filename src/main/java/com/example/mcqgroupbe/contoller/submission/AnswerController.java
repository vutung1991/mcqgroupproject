package com.example.mcqgroupbe.contoller.submission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.service.submission.AnswerService;
import com.example.mcqgroupbe.service.submission.SubmissionService;
import com.example.mcqgroupbe.submission.entity.Answer2;
import com.example.mcqgroupbe.submission.entity.Submission2;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    
    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/save")
    public Answer2 saveAnswer(@RequestBody Answer2 answer) {
        
        Submission2 submission = submissionService.getSubmissionByUserIdAndSetId(answer.getSubmission().getUserId(), answer.getSubmission().getSetId());

        
        answer.setSubmission(submission);

        
        return answerService.saveAnswer(answer);
    }
    
    @PostMapping("/send-score-email")
    public ResponseEntity<String> sendScoreEmailToAdmin(@RequestParam("userId") Long userId, @RequestParam("score") Long score) {
        try {
            submissionService.sendScoreEmailToAdmin(userId, score);
            return ResponseEntity.ok("Score email sent to admin successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending score email to admin.");
        }
    }
    
}