package com.example.mcqgroupbe.submission.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Answer2")
public class Answer2 {
	@Id
	@GeneratedValue(strategy=GenerationType	.IDENTITY)
	@Column(name="answer_Id")
	    private Long answerId;
	@Column(name="question_Id")
	    private Long questionId;
	@Column(name="ans_wer")
	    private String answer;
	@Column(name="Correct_")
	    private boolean correct;

	    @ManyToOne
	    private Submission2 submission;

		public Answer2() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Answer2(Long answerId, Long questionId, String answer, boolean correct, Submission2 submission) {
			super();
			this.answerId = answerId;
			this.questionId = questionId;
			this.answer = answer;
			this.correct = correct;
			this.submission = submission;
		}

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

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public boolean isCorrect() {
			return correct;
		}

		public void setCorrect(boolean correct) {
			this.correct = correct;
		}

		public Submission2 getSubmission() {
			return submission;
		}

		public void setSubmission(Submission2 submission) {
			this.submission = submission;
		}

		@Override
		public String toString() {
			return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", answer=" + answer + ", correct="
					+ correct + ", submission=" + submission + "]";
		}
		
		
}