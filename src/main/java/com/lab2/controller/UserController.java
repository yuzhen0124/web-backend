package com.lab2.controller;

import com.google.gson.Gson;
import com.lab2.mybatis.po.User;
import com.lab2.request.User.UserLoginRequest;
import com.lab2.request.User.UserRegisterRequest;
import com.lab2.request.User.UserUpdateRequest;
import com.lab2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/info")
    public String info(@RequestParam int userID) {
        try {
            User user = userService.getUser(userID);
            if (user != null) {
                Gson gson = new Gson();
                return gson.toJson(user);
            } else
                // 用户不存在
                return "User Not Found";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/update")
    public String update(@RequestBody UserUpdateRequest request) {
        return userService.update(request);
    }

}