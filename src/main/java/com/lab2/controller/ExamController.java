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
            int Num = 2;
            List<Question> questionList = questionService.findAllQuestions();
            List<Integer> questionsIDList = new ArrayList<>();
            for (Question question : questionList) {
                questionsIDList.add(question.getQuestionID());
            }

            List<Integer> selectedIDs = new ArrayList<>();
            Random random = new Random();
            while (selectedIDs.size() < Num) {
                int randomIndex = random.nextInt(questionsIDList.size());
                int questionID = questionsIDList.get(randomIndex);
                if (!selectedIDs.contains(questionID)) {
                    selectedIDs.add(questionID);
                }
            }
            StringBuilder selectQuestions = new StringBuilder();
            for (Integer i : selectedIDs) {
                selectQuestions.append(i).append("-");
            }
            String selectQuestionsString = selectQuestions.toString();

            List<Integer> answers = new ArrayList<>();
            for (Question question : questionList) {
                int answer = question.getAnswer();
                answers.add(answer);
            }
            StringBuilder answersArray = new StringBuilder();
            for (Integer i : answers) {
                answersArray.append(i).append("-");
            }
            String answersArrayString = answersArray.toString();

            Exam exam = new Exam(selectQuestionsString, answersArrayString);

            int examID = examService.addExam(exam);
            return "Add Exam Successfully! Exam ID: " + examID;
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
            //exam.setScore(score);
            //examService.updateExam(exam);
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



}
