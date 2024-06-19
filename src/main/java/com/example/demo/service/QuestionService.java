package com.example.demo.service;

import com.example.demo.mybatis.SqlSessionLoader;
import com.example.demo.mybatis.po.Question;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    public List<Question> findAllQuestions() throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.example.demo.QuestionMapper.findAllQuestions");
        }
    }

    public Question getQuestion( int id ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.example.demo.QuestionMapper.findQuestionById", id);
        }
    }

    public String insertQuestion( Question question ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.example.demo.QuestionMapper.addQuestion", question);
        }
        return "Add Question Successfully!";
    }

    public String updateQuestion( Question question ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.update("com.example.demo.QuestionMapper.updateQuestion", question);
        }
        return "Update Question Successfully!";
    }

    public String deleteQuestion( int id ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.delete("com.example.demo.QuestionMapper.deleteQuestion", id);
        }
        return "Delete Question Successfully!";
    }

}
