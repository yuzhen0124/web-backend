package com.lab2.service;

import com.lab2.mybatis.SqlSessionLoader;
import com.lab2.mybatis.po.Exam;
import com.lab2.mybatis.po.Record;
import com.lab2.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordService {
    public Record getRecordById(int recordID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.lab2.RecordMapper.findRecordById", recordID);
        }
    }

    public String addRecord(Record record) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.lab2.RecordMapper.addRecord", record);
            sqlSession.commit();
        }
        return "Add Record Successfully!";
    }

    public List<Record> getRecordByUser(int userID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.lab2.RecordMapper.findRecordByUserID", userID);
        }
    }

    public String deleteRecord(int recordID) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.lab2.RecordMapper.deleteRecord", recordID);
            sqlSession.commit();
        }
        return "Delete Record Successfully!";
    }
}
