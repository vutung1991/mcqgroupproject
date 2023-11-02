package com.example.mcqgroupbe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.service.SubmissionService;
import com.example.mcqgroupbe.submission.entity.Submission;

@RestController
@RequestMapping("/submissions")
@CrossOrigin(origins="http://localhost:4200/")
public class SubmissionController2 {

	  private final SubmissionService submissionService;
	@Autowired
    public SubmissionController2(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/getbysubid/{submissionId}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable int submissionId) {
        Optional<Submission> submission = submissionService.getSubmissionById(submissionId);
        return submission.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        Submission createdSubmission = submissionService.createSubmission(submission);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubmission);
    }

    @PutMapping("/update/{submissionId}")
    public ResponseEntity<Void> updateSubmission(@PathVariable int submissionId, @RequestBody Submission submission) {
        submissionService.updateSubmission(submissionId, submission);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{submissionId}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable int submissionId) {
        submissionService.deleteSubmission(submissionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getbyuser/{userId}")
    public ResponseEntity<List<Submission>> getAllSubmissionsByUserId(@PathVariable int userId) {
        List<Submission> submissions = submissionService.getAllSubmissionsByUserId(userId);
        return ResponseEntity.ok(submissions);
    }
}
