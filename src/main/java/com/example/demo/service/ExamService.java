package com.example.demo.service;

import com.example.demo.mybatis.SqlSessionLoader;
import com.example.demo.mybatis.po.Exam;
import com.example.demo.mybatis.po.Question;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {
    public List<Exam> getExams() throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.example.demo.ExamMapper.findAllExams");
        }
    }
    public Exam getExam(int examId) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.example.demo.ExamMapper.findExamById", examId);
        }
    }

    public int addExam(Exam exam) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.example.demo.ExamMapper.addExam", exam);
            sqlSession.commit();
        }
        return exam.getExamID();
    }

    public void updateExam(Exam exam) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.update("com.example.demo.ExamMapper.updateExam", exam);
            sqlSession.commit();
        }
    }

    public int calculateScore(int examID, String options) throws Exception {
        int score = 0;
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            Exam exam = sqlSession.selectOne("com.example.demo.ExamMapper.findExamById", examID);
            exam.setOptions(options);
            String answers = exam.getAnswers();
            List<Integer> answersList = stringToList(answers);
            String[] optionsArray = options.split("-");
            // 计算得分
            for (int i = 0; i < optionsArray.length; i++) {
                int selectedOption = Integer.parseInt(optionsArray[i]);
                int correctAnswer = answersList.get(i);
                if (selectedOption == correctAnswer) {
                    score++;
                }
            }
            exam.setScore(score);

            sqlSession.update("com.example.demo.ExamMapper.updateExam", exam);
            sqlSession.commit();
        }
        return score;
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
}
