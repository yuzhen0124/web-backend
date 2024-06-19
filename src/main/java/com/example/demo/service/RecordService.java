package com.example.demo.service;

import com.example.demo.mybatis.SqlSessionLoader;
import com.example.demo.mybatis.po.Exam;
import com.example.demo.mybatis.po.Record;
import com.example.demo.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordService {
    public Record getRecordById(int recordID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.example.demo.RecordMapper.findRecordById", recordID);
        }
    }

    public String addRecord(Record record) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.example.demo.RecordMapper.addRecord", record);
            sqlSession.commit();
        }
        return "Add Record Successfully!";
    }

    public List<Record> getRecordByUser(int userID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.example.demo.RecordMapper.findRecordByUserID", userID);
        }
    }

    public String deleteRecord(int recordID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.example.demo.RecordMapper.deleteRecord", recordID);
            sqlSession.commit();
        }
        return "Delete Record Successfully!";
    }
}
