package com.example.mcqgroupbe.repository.submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mcqgroupbe.submission.entity.Submission2;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission2, Long> {
    Submission2 findByUserIdAndSetId(Long userId, int setId);
}
