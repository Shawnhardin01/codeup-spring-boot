package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
    class helloController {

        @GetMapping("/hello")

        @ResponseBody
        public String hello() {
            return "Hello ";
        }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello"+name+"!";
    }
    @GetMapping("/dice")
    @ResponseBody
    public String Diceroll() {
       int Diceroll = (int) (Math.random() *20)+1;
      return  "you rolled" +" : "+ Diceroll;
    }
        @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
        @ResponseBody
        public String addOne(@PathVariable int number) {
            return number + " plus one is " + (number + 1);
        }
    }

