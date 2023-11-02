package com.example.mcqgroupbe.submission.entity;

import java.util.List;

import com.example.mcqgroupbe.entity.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Submission")
public class Submission {
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
    private List<Answer> answers;
	
	public Submission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Submission(long id, long userId, int setId, long score) {
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
	    for (Answer answer : this.answers) {
	        if (answer.isCorrect()) {
	            correctAnswers++;
	        }
	    }
	    this.score = correctAnswers;
	}
    
    public List<Answer> getAnswers() {
        return this.answers;
    }
	

}