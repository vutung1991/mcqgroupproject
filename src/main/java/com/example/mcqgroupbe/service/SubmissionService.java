package com.example.mcqgroupbe.service;

import java.util.List;
import java.util.Optional;

import com.example.mcqgroupbe.submission.entity.Submission;


public interface SubmissionService {

    List<Submission> getAllSubmissions();

    Optional<Submission> getSubmissionById(int submissionId);

    Submission createSubmission(Submission submission);

    void updateSubmission(int submissionId, Submission submission);

    void deleteSubmission(int submissionId);
    
    List<Submission> getAllSubmissionsByUserId(int userId);
}
