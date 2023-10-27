package com.example.mcqgroupbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Submissions")
public class Submission {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subId")
	private long submissionId;
    
	private long userId;
	private long setId;
	private int score;
	
	public Submission() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public Submission(long submissionId, long userId, long setId, int score) {
		super();
		this.submissionId = submissionId;
		this.userId = userId;
		this.setId = setId;
		this.score = score;
	}

	public long getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(long submissionId) {
		this.submissionId = submissionId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSetId() {
		return setId;
	}

	public void setSetId(long setId) {
		this.setId = setId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	
	
	
	
	

}
