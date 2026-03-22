package com.rollerspeed.rollerspeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.rollerspeed.Service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("datosUsuarios", userService.getAllUsers());
        return "users";
    }   
}
