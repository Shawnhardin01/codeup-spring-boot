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
    public String subtract(@PathVariable int num1,@PathVariable int num2) {
        int difference = num1 - num2;
        return num2 + "-" + num1 + "=" + difference;
    }


    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int num1,@PathVariable int  num2) {
        int product =num1 *  num2;
        return num1+ "*" +  num2 + "=" + product;
    }


    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public String divide(@PathVariable int num1,@PathVariable int  num2) {
        int quotient = num1 /  num2;

        return num1 + "÷" +  num2 + "=" + quotient;
    }
}