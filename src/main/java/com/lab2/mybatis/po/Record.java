package com.lab2.mybatis.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Record {
    private int recordID;
    private int examID;
    private int userID;
    private int score;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinDate;

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }
    public int getExamId() {
        return examID;
    }
    public void setExamId(int examId) {
        this.examID = examId;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
