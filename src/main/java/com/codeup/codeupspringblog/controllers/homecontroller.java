package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homecontroller {
    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "This is my landing page!";
    }
}