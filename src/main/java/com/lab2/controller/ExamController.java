package com.lab2.controller;

import com.google.gson.Gson;
import com.lab2.mybatis.po.Exam;
import com.lab2.mybatis.po.Question;
import com.lab2.request.Exam.ExamSubmitRequest;
import com.lab2.service.ExamService;
import com.lab2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService questionService;


    @GetMapping ("/add")
    public String addExam() {
        try {
            int Num = 5;
            List<Question> questionList = questionService.findAllQuestions();
            List<Question> selectedQuestions = randomSelect(questionList, Num);

            List<Integer> questionIDs = new ArrayList<>();
            for (Question question : selectedQuestions) {
                int questionID = question.getQuestionID();
                questionIDs.add(questionID);
            }
            String selectQuestionsString = ListToString(questionIDs);

            List<Integer> answers = new ArrayList<>();
            for (Question question : selectedQuestions) {
                int answer = question.getAnswer();
                answers.add(answer);
            }
            String answersArrayString = ListToString(answers);

            Exam exam = new Exam(selectQuestionsString, answersArrayString);

            int examID = examService.addExam(exam);
            return "Add Exam Successfully! Exam ID: " + examID;
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/{examID}")
    public String getExam(@PathVariable int examID) {
        try {
            Exam exam = examService.getExam(examID);
            if(exam != null) {
                Gson gson = new Gson();
                return gson.toJson(exam);
            } else {
                return "Exam Not found";
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/questions")
    public String getQuestions(@RequestParam int examID) {
        try {
            Exam exam = examService.getExam(examID);
            String questionsString = exam.getQuestions();
            List<Integer> questions = stringToList(questionsString);
            List<Question> questionList = new ArrayList<>();

            for (Integer i : questions) {
                questionList.add(questionService.getQuestion(i));
            }
            if(!questionList.isEmpty()) {
                Gson gson = new Gson();
                return gson.toJson(questionList);
            } else {
                return "No questions found";
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/submit")
    public String submit(@RequestBody ExamSubmitRequest request) {
        try {
            Exam exam = examService.getExam(request.getExamID());
            if(exam == null) { return "No exam found"; }
            String options = request.getOptions();
            exam.setOptions(options);

            int score = examService.calculateScore(request.getExamID(), options);

            return "Exam Submitted Successfully!Score: " + score;
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    private List<Integer> stringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] inputArray = input.split("-");
        for (String s : inputArray) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    private String ListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static List<Question> randomSelect(List<Question> questionList, int Num) {
        if (Num >= questionList.size()) {
            // 如果要选择的数量大于等于题目列表的大小，直接返回题目列表
            return questionList;
        }

        // 创建一个用于存放随机选择的题目的列表
        List<Question> selectedQuestions = new ArrayList<>();

        // 将题目列表进行随机排序
        List<Question> shuffledList = new ArrayList<>(questionList);
        Collections.shuffle(shuffledList);

        // 从随机排序后的列表中取前 num 个题目作为选择结果
        for (int i = 0; i < Num; i++) {
            selectedQuestions.add(shuffledList.get(i));
        }

        return selectedQuestions;
    }


}
