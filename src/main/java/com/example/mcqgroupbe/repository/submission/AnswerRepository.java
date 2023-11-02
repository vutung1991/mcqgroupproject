package com.example.mcqgroupbe.repository.submission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mcqgroupbe.submission.entity.Answer2;

@Repository
public interface AnswerRepository extends JpaRepository<Answer2, Long> {
    List<Answer2> findBySubmissionId(Long submissionId);
}
