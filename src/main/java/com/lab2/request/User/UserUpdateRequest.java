package com.lab2.request.User;

public class UserUpdateRequest {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String image;

    public int getUserID() { return userID; }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() { return image; }

}
