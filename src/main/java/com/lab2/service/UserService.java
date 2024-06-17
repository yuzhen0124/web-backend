package com.lab2.service;

import com.lab2.mybatis.SqlSessionLoader;
import com.lab2.mybatis.po.User;
import com.lab2.request.User.UserLoginRequest;
import com.lab2.request.User.UserRegisterRequest;
import com.lab2.request.User.UserUpdateRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    public String register(UserRegisterRequest request) {
        // 注册逻辑
        try{
            SqlSession sqlSession = SqlSessionLoader.getSqlSession();

            User user1 = sqlSession.selectOne("com.lab2.UserMapper.findUserByUsername",
                    request.getUsername());
            User user2 = sqlSession.selectOne("com.lab2.UserMapper.findUserByPhone", request.getPhone());
            if (user1 != null) { // 用户名重复
                sqlSession.close();
                return "The username is already used";
           } else if (user2 != null) { // 电话号码重复
                sqlSession.close();
                return "The phone number is already used";
            }else {
                sqlSession.insert("com.lab2.UserMapper.addUser",
                        new User(request.getUsername(), request.getPassword(),
                                request.getEmail(), request.getPhone(), request.getImage()));
                sqlSession.commit();
                sqlSession.close();
                return "Register Successfully!";
            }
        } catch (Exception e) {
            // 返回错误消息
            return "An error occurred: " + e.getMessage();
        }
    }

    public String login(UserLoginRequest request) {
        // 登录逻辑
        try {
            SqlSession sqlSession = SqlSessionLoader.getSqlSession();
            User user = sqlSession.selectOne("com.lab2.UserMapper.findUserByUsernameAndPassword",
                    new User(request.getUsername(), request.getPassword()));
            sqlSession.close();
            if (user == null) {
                // 用户名或密码错误，返回错误响应
                return "Invalid username or password";
            }else
                return "Login Successfully! User ID: " + user.getUserID();
        } catch (Exception e) {
            // 返回错误消息
            return "An error occurred: " + e.getMessage();
        }
    }

    public User getUser(int userID) throws Exception{
        // 获取用户信息逻辑
        try (SqlSession sqlSession = SqlSessionLoader.getSqlSession()) {
            return sqlSession.selectOne("com.lab2.UserMapper.findUserById", userID);
        }
    }

    public String update(UserUpdateRequest request) {
        // 更新用户信息逻辑
        try {
            SqlSession sqlSession = SqlSessionLoader.getSqlSession();
            User user = sqlSession.selectOne("com.lab2.UserMapper.findUserById", request.getUserID());
            if(user == null) {
                sqlSession.close();
                return "User Not Found";
            }
            User user1= sqlSession.selectOne("com.lab2.UserMapper.findUserByUsername", request.getUsername());
            User user2 = sqlSession.selectOne("com.lab2.UserMapper.findUserByPhone", request.getPhone());
            if (user1 != null && user1.getUserID() != request.getUserID()) { // 用户名重复
                sqlSession.close();
                return "The username is already used";
            } else if (user2 != null && user2.getUserID() != request.getUserID()) { // 电话号码重复
                sqlSession.close();
                return "The phone number is already used";
            } else {
                sqlSession.update("com.lab2.UserMapper.updateUser",
                        new User(request.getUserID(), request.getUsername(), request.getPassword(),
                                request.getEmail(), request.getPhone(), request.getImage()));
                sqlSession.commit();
                sqlSession.close();
                return "Update Successfully!";
            }
        } catch (Exception e) {
            // 返回错误消息
            return "An error occurred: " + e.getMessage();
        }
    }
}
