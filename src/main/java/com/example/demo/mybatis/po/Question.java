package com.example.demo.mybatis.po;

public class Question {
    private int questionID;
    private String text;
    private String option1;
    private String option2;
    private String option3;
    private int answer;

    public Question (String text, String option1, String option2, String option3, int answer) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
    }
    public Question (int questionID, String text, String option1, String option2, String option3, int answer) {
        this.questionID = questionID;
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
    }
    public int getQuestionID() {
        return questionID;
    }
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public int getAnswer() {
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
