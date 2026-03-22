package com.rollerspeed.rollerspeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.rollerspeed.Model.UserModel;
import com.rollerspeed.rollerspeed.Service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("datosUsuarios", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("nuevoUsuario", new UserModel());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("nuevoUsuario") UserModel user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }
}
