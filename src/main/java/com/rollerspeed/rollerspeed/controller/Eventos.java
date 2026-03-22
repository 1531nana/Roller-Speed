package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventos")
public class Eventos {

    @GetMapping
    public String mostrarEventos() {
        return "eventos"; // eventos.html
    }

}
