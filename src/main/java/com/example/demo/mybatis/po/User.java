package com.example.demo.mybatis.po;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String image;

    public User(int userID, String username, String password,
                String email, String phone, String image) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }
    public User(int userID, String username, String password,
                String email, String phone) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User(String username, String password, String email, String phone, String image) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}