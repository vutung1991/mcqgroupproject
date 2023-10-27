package com.example.mcqgroupbe.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qn_no")
    private int qnNo;

    @Column(name = "question")
    private String question;

    @Column(name = "opt_1")
    private String opt1;

    @Column(name = "opt_2")
    private String opt2;

    @Column(name = "opt_3")
    private String opt3;

    @Column(name = "opt_4")
    private String opt4;

    @Column(name = "correct_answer")
    private int correctAnswer;

    @Column(name = "set_id")
    private int setId;

    @Column(name = "topic_id")
    private int topicId;
    // Constructors, getters, and setters as needed

    public Question() {
        // Default constructor
    }

    public Question(String question, String opt1, String opt2, String opt3, String opt4, int correctAnswer, int setId) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.correctAnswer = correctAnswer;
        this.setId = setId;
    }

    // Getters and setters for all fields

    public int getQnNo() {
        return qnNo;
    }

    public void setQnNo(int qnNo) {
        this.qnNo = qnNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }
    public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return "Question [qnNo=" + qnNo + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3="
				+ opt3 + ", opt4=" + opt4 + ", correctAnswer=" + correctAnswer + ", setId=" + setId + ", topicId="
				+ topicId + "]";
	}
    
}
