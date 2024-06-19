package com.example.demo.service;

import com.example.demo.mybatis.SqlSessionLoader;
import com.example.demo.mybatis.po.Art;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService {
    public List<Art> findAllArts() throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.example.demo.ArtMapper.findAllArts");
        }
    }

    public Art getArt( int id ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.example.demo.ArtMapper.findArtById", id);
        }
    }

    public String insertArt( Art art ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.example.demo.ArtMapper.addArt", art);
            sqlSession.commit();
        }
        return "Add Art Successfully!";
    }

    public String updateArt( Art art ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.update("com.example.demo.ArtMapper.updateArt", art);
            sqlSession.commit();
        }
        return "Update Art Successfully!";
    }

}
