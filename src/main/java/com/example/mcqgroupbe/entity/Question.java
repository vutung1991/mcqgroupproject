package com.example.mcqgroupbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Question {

    private int qNo;
    private String question;
    private String opt_a;
    private String opt_b;
    private String opt_c;
    private String opt_d;
    private int correct;
    private int setId;
    private int topicId;

}
