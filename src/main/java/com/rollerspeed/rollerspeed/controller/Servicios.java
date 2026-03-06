package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/servicios")
public class Servicios {

@GetMapping
    public String Servicios() {
        
        return "servicios"; 
    }
}
