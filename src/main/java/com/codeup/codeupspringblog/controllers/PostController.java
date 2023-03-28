package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.persistence.*;

@Entity
@Controller
public class PostController {


    @GetMapping("/posts")
    @ResponseBody
    public String postsPage() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "view an individual post from id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostPage() {
        return "view the form for creating a post";
    }
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 100)
        private String title;

        @Column(nullable = false)
        private String description;


    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatePostPage() {
        return "create a new post";
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}