package com.example.mcqgroupbe.controller;

import com.example.mcqgroupbe.entity.Question;
import com.example.mcqgroupbe.entity.TopicAndSetIds;
import com.example.mcqgroupbe.repository.QuestionRepository;
import com.example.mcqgroupbe.service.IQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final IQuestionService questionService;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, IQuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    @GetMapping("/getall")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionRepository.findById(id).orElse(null);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")    
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/update/{id}")
    public Question updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setQuestion(updatedQuestion.getQuestion());
            existingQuestion.setOpt1(updatedQuestion.getOpt1());
            existingQuestion.setOpt2(updatedQuestion.getOpt2());
            existingQuestion.setOpt3(updatedQuestion.getOpt3());
            existingQuestion.setOpt4(updatedQuestion.getOpt4());
            existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
            existingQuestion.setSetId(updatedQuestion.getSetId());
            return questionRepository.save(existingQuestion);
        } else {
            return null; // Handle not found case
        }
    }
    
    @PostMapping("/getByIdAndTopic")
    public List<Question> getBySetIdAndTopicID(@RequestBody TopicAndSetIds topicAndSetIds){
    	return questionService.getQuestionbyTopicAndSetId(topicAndSetIds.getTopicId(),topicAndSetIds.getSetId());
    }
    
    @GetMapping("/byTopicId/{topicId}")
    public List<Question> getByTopicID(@PathVariable int topicId){
    	return questionService.getQuestionbyTopicId(topicId);
    }
    

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionRepository.deleteById(id);
    }
    
   
}
