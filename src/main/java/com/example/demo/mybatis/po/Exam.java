package com.example.demo.mybatis.po;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Exam {
    private int examID;
    private String questions;  // 存储题目id，以‘-’间隔
    private String answers;  // 存储题目答案
    private String options;  // 存储用户作答选项
    private int score;

    public Exam(int examID, String questions, String answers, String options, int score) {
        this.examID = examID;
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.score = score;
    }

    public Exam (String questions, String answers) {
        this.questions = questions;
        this.answers = answers;
    }

    public Exam (int examID, String options, int score) {
        this.examID = examID;
        this.options = options;
        this.score = score;
    }

}
