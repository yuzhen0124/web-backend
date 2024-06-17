package com.lab2.service;

import com.lab2.mybatis.SqlSessionLoader;
import com.lab2.mybatis.po.Question;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    public List<Question> findAllQuestions() throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.lab2.QuestionMapper.findAllQuestions");
        }
    }

    public Question getQuestion( int id ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.lab2.QuestionMapper.findQuestionById", id);
        }
    }

    public String insertQuestion( Question question ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.lab2.QuestionMapper.addQuestion", question);
        }
        return "Add Question Successfully!";
    }

    public String updateQuestion( Question question ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.update("com.lab2.QuestionMapper.updateQuestion", question);
        }
        return "Update Question Successfully!";
    }


}
