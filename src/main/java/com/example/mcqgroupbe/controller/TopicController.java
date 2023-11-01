package com.example.mcqgroupbe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcqgroupbe.entity.Topic;
import com.example.mcqgroupbe.service.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin(origins="http://localhost:4200/")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/getbyid/{topicId}")
    public ResponseEntity<Topic> getTopicById(@PathVariable int topicId) {
        Optional<Topic> topic = topicService.getTopicById(topicId);
        return topic.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic createdTopic = topicService.createTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
    }

    @PutMapping("/update/{topicId}")
    public ResponseEntity<Void> updateTopic(@PathVariable int topicId, @RequestBody Topic topic) {
        topicService.updateTopic(topicId, topic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{topicId}")
    public ResponseEntity<Void> deleteTopic(@PathVariable int topicId) {
        topicService.deleteTopic(topicId);
        return ResponseEntity.noContent().build();
    }
}
