package com.example.mcqgroupbe.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
