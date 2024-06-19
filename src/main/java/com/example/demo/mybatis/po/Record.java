package com.example.demo.mybatis.po;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Record {
    private int recordID;
    private int userID;
    private int examID;
    private Date joinDate;

    private int score;


    public Record(int recordID, int userID, int examID, Date joinDate, int score) {
        this.recordID = recordID;
        this.userID = userID;
        this.examID = examID;
        this.joinDate = joinDate;
        this.score = score;
    }

    public Record(int recordID, int userID, int examID, LocalDateTime joinDate, int score) {
        this.recordID = recordID;
        this.userID = userID;
        this.examID = examID;
        this.joinDate = Date.from(joinDate.atZone(ZoneId.of("GMT+8")).toInstant());
        this.score = score;
    }

    public Record(int userID, int examID, Date joinDate, int score) {
        this.examID = examID;
        this.userID = userID;
        this.score = score;
        this.joinDate = joinDate;
    }

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
