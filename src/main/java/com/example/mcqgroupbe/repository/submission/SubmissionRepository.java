package com.example.mcqgroupbe.repository.submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mcqgroupbe.submission.entity.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    Submission findByUserIdAndSetId(Long userId, int setId);
}
