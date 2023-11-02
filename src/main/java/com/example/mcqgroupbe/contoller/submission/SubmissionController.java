package com.example.mcqgroupbe.contoller.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.service.submission.AnswerService;
import com.example.mcqgroupbe.service.submission.SubmissionService;
import com.example.mcqgroupbe.submission.entity.Answer2;
import com.example.mcqgroupbe.submission.entity.Submission2;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private AnswerService answerService;

    @PostMapping("/create")
    public Submission2 createSubmission(@RequestBody Submission2 submission) {
        return submissionService.createSubmission(submission);
    }

    @GetMapping("/{submissionId}/answers")
    public List<Answer2> getAnswersForSubmission(@PathVariable Long submissionId) {
        return answerService.getAnswersBySubmissionId(submissionId);
    }
}
