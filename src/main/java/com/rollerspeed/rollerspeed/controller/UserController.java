package com.rollerspeed.rollerspeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers() {
        return "users";
    }   
}
