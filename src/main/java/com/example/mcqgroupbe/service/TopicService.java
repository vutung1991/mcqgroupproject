package com.example.mcqgroupbe.service;

import java.util.List;
import java.util.Optional;

import com.example.mcqgroupbe.entity.Topic;

public interface TopicService {

    List<Topic> getAllTopics();

    Optional<Topic> getTopicById(int topicId);

    Topic createTopic(Topic topic);

    void updateTopic(int topicId, Topic topic);

    void deleteTopic(int topicId);
}