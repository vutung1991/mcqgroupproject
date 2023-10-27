package com.example.mcqgroupbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mcqgroupbe.entity.Topic;
import com.example.mcqgroupbe.repository.TopicRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Optional<Topic> getTopicById(int topicId) {
        return topicRepository.findById(topicId);
    }

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public void updateTopic(int topicId, Topic topic) {
    	 Optional<Topic> existingTopic = topicRepository.findById(topicId);
         if (existingTopic.isPresent()) {
             topic.setTopicId(topicId);
             topicRepository.save(topic);
         } else {
             throw new EntityNotFoundException("Topic with ID " + topicId + " not found");
         }
    }

    @Override
    public void deleteTopic(int topicId) {
        topicRepository.deleteById(topicId);
    }
}