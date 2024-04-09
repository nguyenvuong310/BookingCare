package com.example.bookingCare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Swagger {
    @RequestMapping("/")
    public String ShowAPI(){
        return "index";
    }
}
