package com.example.mcqgroupbe.repository;
import com.example.mcqgroupbe.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
}
