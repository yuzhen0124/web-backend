package com.example.demo.controller;

import com.google.gson.Gson;
import com.example.demo.mybatis.po.Question;
import com.example.demo.request.Question.QuestionAddRequest;
import com.example.demo.request.Question.QuestionUpdateRequest;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public String getAllQuestions() {
        try {
            List<Question> questions = questionService.findAllQuestions();
            if(questions.isEmpty()){
                return "no questions found";
            } else {
                Gson gson = new Gson();
                return gson.toJson(questions);
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/{questionID}")
    public String getQuestionById(@PathVariable("questionID") int questionID) {
        try {
            Question question = questionService.getQuestion(questionID);
            if(question == null){
                return "Question Not Found";
            } else {
                Gson gson = new Gson();
                return gson.toJson(question);
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody QuestionAddRequest request) {
        try {
            Question question = new Question(request.getText(), request.getOption1(), request.getOption2(),
                    request.getOption3(), request.getAnswer());
            return questionService.insertQuestion(question);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/update")
    public String updateQuestion(@RequestBody QuestionUpdateRequest request) {
        try {
            Question question = new Question(request.getQuestionID(), request.getText(), request.getOption1(), request.getOption2(),
                    request.getOption3(), request.getAnswer());
            return questionService.updateQuestion(question);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/delete")
    public String deleteQuestion(@RequestParam("questionID") int questionID) {
        try {
            Question question = questionService.getQuestion(questionID);
            if(question == null) {return "Question Not Found";}
            return questionService.deleteQuestion(questionID);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
