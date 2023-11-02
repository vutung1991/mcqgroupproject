package com.example.mcqgroupbe.contoller.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.Answer;
import com.example.mcqgroupbe.service.submission.AnswerService;
import com.example.mcqgroupbe.service.submission.SubmissionService;
import com.example.mcqgroupbe.submission.entity.Submission;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private AnswerService answerService;

    @PostMapping("/create")
    public Submission createSubmission(@RequestBody Submission submission) {
        return submissionService.createSubmission(submission);
    }

    @GetMapping("/{submissionId}/answers")
    public List<Answer> getAnswersForSubmission(@PathVariable Long submissionId) {
        return answerService.getAnswersBySubmissionId(submissionId);
    }
}
