package com.example.demo.controller;

import com.google.gson.Gson;
import com.example.demo.mybatis.po.Record;
import com.example.demo.request.Record.RecordAddRequest;
import com.example.demo.service.ExamService;
import com.example.demo.service.RecordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamService examService;

    @PostMapping("/add")
    public String addRecord(@RequestBody RecordAddRequest request) {
        try {
            if(userService.getUser(request.getUserID()) == null) return "User Not Found.Fail To Add Record";
            if(examService.getExam(request.getExamID()) == null) return "Exam Not Found.Fail To Add Record";

            Record record = new Record(request.getUserID(), request.getExamID(), request.getJoinDate(),
                    request.getScore());
            return recordService.addRecord(record);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/get/{recordID}")
    public String getRecordById(@PathVariable("recordID") int recordID) {
        try {
            Record record = recordService.getRecordById(recordID);
            if(record != null) {
                Gson gson = new Gson();
                return gson.toJson(record);
            } else {
                return "Record not found";
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/get")
    public String getRecordByUser(@RequestParam("userID") int userID) {
        try {
            List<Record> records = recordService.getRecordByUser(userID);
            if(records != null) {
                Gson gson = new Gson();
                return gson.toJson(records);
            } else {
                return "Record not found";
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/delete")
    public String deleteRecord(@RequestParam("recordID") int recordID) {
        try {
            Record record = recordService.getRecordById(recordID);
            if(record == null) { return "Record not found"; }
            recordService.deleteRecord(recordID);
            return "Record deleted Successfully";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
