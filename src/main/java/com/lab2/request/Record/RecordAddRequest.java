package com.lab2.request.Record;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class RecordAddRequest {
    private int examID;
    private int userID;
    private int score;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinDate;
    //private LocalDateTime joinDate;

    public int getExamID() {
        return examID;
    }

    public int getUserID() {
        return userID;
    }

    public int getScore() {
        return score;
    }

    public Date getJoinDate() {
        return joinDate;
    }

}
