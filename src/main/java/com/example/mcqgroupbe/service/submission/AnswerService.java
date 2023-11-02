package com.example.mcqgroupbe.service.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.repository.submission.AnswerRepository;
import com.example.mcqgroupbe.submission.entity.Answer2;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer2 saveAnswer(Answer2 answer) {
        return answerRepository.save(answer);
    }

    public List<Answer2> getAnswersBySubmissionId(Long submissionId) {
        return answerRepository.findBySubmissionId(submissionId);
    }
}
