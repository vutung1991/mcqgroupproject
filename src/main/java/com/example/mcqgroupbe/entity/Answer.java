package com.example.mcqgroupbe.entity;

import com.example.mcqgroupbe.submission.entity.Submission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Long answerId;

	@Column(name = "question_id")
	private Long questionId;

	@Column(name = "submission_id")
	private Long submissionId;

	@Column(name = "answer_selection")
	private Long answerSelection;

	@Column(name = "correct")
	private boolean correct;
    @ManyToOne
    private Submission submission;

	// Constructors, getters, and setters as needed

	public Answer() {
		// Default constructor
	}

	public Answer(Long questionId, Long submissionId, Long answerSelection, boolean correct) {
		this.questionId = questionId;
		this.submissionId = submissionId;
		this.answerSelection = answerSelection;
		this.correct = correct;
	}

	// Getters and setters for all fields

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Long submissionId) {
		this.submissionId = submissionId;
	}

	public Long getAnswerSelection() {
		return answerSelection;
	}

	public void setAnswerSelection(Long answerSelection) {
		this.answerSelection = answerSelection;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
		
	}
	
	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}
	
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", answer=" + answerSelection + ", correct="
				+ correct + ", submission=" + submission + "]";
	}
	
}
