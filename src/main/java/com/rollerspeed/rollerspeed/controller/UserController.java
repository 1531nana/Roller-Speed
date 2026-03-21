package com.rollerspeed.rollerspeed.controller;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("datosUsuarios", Collections.emptyList());
		return "user";
	}
}
