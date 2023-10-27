package com.example.mcqgroupbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.Submission;
import com.example.mcqgroupbe.repository.SubmissionRepository;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Optional<Submission> getSubmissionById(int submissionId) {
        return submissionRepository.findById(submissionId);
    }

    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public void updateSubmission(int submissionId, Submission submission) {
        // Ensure the submission with the given ID exists before updating
        if (submissionRepository.existsById(submissionId)) {
            submission.setSubmissionId(submissionId);
            submissionRepository.save(submission);
        }
        // Handle the case when the submission with the given ID doesn't exist
        // You can throw an exception or handle it according to your application's logic
    }

    @Override
    public void deleteSubmission(int submissionId) {
        submissionRepository.deleteById(submissionId);
    }
    @Override
    public List<Submission> getAllSubmissionsByUserId(int userId) {
        return submissionRepository.findAllByUserId(userId);
    }
}