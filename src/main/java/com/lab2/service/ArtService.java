package com.lab2.service;

import com.lab2.mybatis.SqlSessionLoader;
import com.lab2.mybatis.po.Art;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService {
    public List<Art> findAllArts() throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectList("com.lab2.ArtMapper.findAllArts");
        }
    }

    public Art getArt( int id ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.lab2.ArtMapper.findArtById", id);
        }
    }

    public String insertArt( Art art ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.insert("com.lab2.ArtMapper.addArt", art);
            sqlSession.commit();
        }
        return "Add Art Successfully!";
    }

    public String updateArt( Art art ) throws Exception {
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            sqlSession.update("com.lab2.ArtMapper.updateArt", art);
            sqlSession.commit();
        }
        return "Update Art Successfully!";
    }

}
