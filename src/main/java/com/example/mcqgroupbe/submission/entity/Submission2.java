package com.example.mcqgroupbe.submission.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Submission2")
public class Submission2 {
	@Id
	@GeneratedValue(strategy=GenerationType	.IDENTITY)
	@Column(name="submissionId")
	private Long id;
	@Column(name="user_id")
	private long userId;
	@Column(name="set_id")
	private int setId;
	
	@Column(name="scores")
	private long score;
	@OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    private List<Answer2> answers;
	
	public Submission2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Submission2(long id, long userId, int setId, long score) {
		super();
		this.id = id;
		this.userId = userId;
		this.setId = setId;
		this.score = score;
	}

	public Long getId() {
        return this.id;
    }
    

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "submission [id=" + id + ", userId=" + userId + ", setId=" + setId + ", score=" + score + "]";
	}
	
	public void setScore() {
	    int correctAnswers = 0;
	    for (Answer2 answer : this.answers) {
	        if (answer.isCorrect()) {
	            correctAnswers++;
	        }
	    }
	    this.score = correctAnswers;
	}
    
    public List<Answer2> getAnswers() {
        return this.answers;
    }
	

}