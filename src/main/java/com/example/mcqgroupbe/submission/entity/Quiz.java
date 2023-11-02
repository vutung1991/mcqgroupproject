package com.example.mcqgroupbe.submission.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="Title")
 private String title;
 @Column(name="is_active")
 private boolean active;
 @Column(name="topic_id")
 private Long topicId;
public Quiz() {
	super();
	// TODO Auto-generated constructor stub
}
public Quiz(Long id, String title, boolean active, Long topicId) {
	super();
	this.id = id;
	this.title = title;
	this.active = active;
	this.topicId = topicId;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean isActive) {
	this.active = isActive;
}
public Long getTopicId() {
	return topicId;
}
public void setTopicId(Long topicId) {
	this.topicId = topicId;
}
@Override
public String toString() {
	return "quiz [id=" + id + ", title=" + title + ", isActive=" + active + ", topicId=" + topicId + "]";
} 
 
 
 
 
}
