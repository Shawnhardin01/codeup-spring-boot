package com.codeup.controllers;

import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;

public class emailcontroller{
    @Controller
     class emailcontroller {

        private final EmailService emailService;

        public emailcontroller(EmailService emailService) {
            this.emailService = emailService;
        }
    }
}
