package com.lab2.mybatis.po;

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

    public int getExamID() {
        return examID;
    }
    public void setExamID(int examID) {
        this.examID = examID;
    }
    public String getQuestions() {
        return questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions;
    }
    public String getAnswers() {
        return answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }
    public String getOptions() {
        return options;
    }
    public void setOptions(String options) {
        this.options = options;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
