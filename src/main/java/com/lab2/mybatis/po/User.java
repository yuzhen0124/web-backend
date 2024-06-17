package com.lab2.mybatis.po;

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
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}