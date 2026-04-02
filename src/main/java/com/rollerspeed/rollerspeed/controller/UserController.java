package com.rollerspeed.rollerspeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addUser(@ModelAttribute("nuevoUsuario") UserModel user) throws Exception {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        UserModel usuario = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        model.addAttribute("usuario", usuario);
        return "viewUser";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        UserModel usuario = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        model.addAttribute("usuario", usuario);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("usuario") UserModel userDetails) {
        userService.updateUser(id, userDetails);
        return "redirect:/users/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }
}
