package com.example.mcqgroupbe.service.submission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.Answer;
import com.example.mcqgroupbe.repository.submission.AnswerRepository;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAnswersBySubmissionId(Long submissionId) {
        return answerRepository.findBySubmissionId(submissionId);
    }
}
