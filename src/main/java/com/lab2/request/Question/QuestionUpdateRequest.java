package com.lab2.request.Question;

public class QuestionUpdateRequest {
    private int questionID;
    private String text;
    private String option1;
    private String option2;
    private String option3;
    private int answer;

    public int getQuestionID() {
        return questionID;
    }

    public String getText() {
        return text;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public int getAnswer() {
        return answer;
    }
}
