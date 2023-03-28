package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x,@PathVariable int y) {
        int sum = x + y;
        return x + "+" + y + "=" + sum;
    }


    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x,@PathVariable int y) {
        int difference = y - x;
        return y + "-" + x + "=" + difference;
    }


    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x,@PathVariable int y) {
        int product = x * y;
        return x + "*" + y + "=" + product;
    }


    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public String divide(@PathVariable int x,@PathVariable int y) {
        int quotient = x / y;

        return x + "÷" + y + "=" + quotient;
    }
}