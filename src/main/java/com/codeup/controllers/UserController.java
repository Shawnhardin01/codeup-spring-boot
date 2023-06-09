package com.codeup.controllers;


import com.codeup.repositories.UserRepository;
import com.codeup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;



    public UserController(UserRepository userDao) {
        this.userDao = userDao;

    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){

        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/login";
    }
}