package com.example.mcqgroupbe.entity;

import jakarta.persistence.*;


@Entity
@Table(name= "Topics")
public class Topic {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "topicId")
	 private Long topicId;

	 @Column(name = "topicName")
	 private String topicName;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(Long topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	 

}
