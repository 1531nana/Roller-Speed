package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/servicios")
public class Servicios {

    @GetMapping
    public String servicios() {
        return "servicios"; 
    }
}
