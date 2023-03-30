package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@Controller
public class PostController {


    public PostController(PostRepository postDoa, UserRepository userDoa) {

    }

    public PostController() {

    }


    @GetMapping("/posts")
    @ResponseBody
    public String postsPage() {
        return "posts index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "view a post from id " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostPage() {
        return "view form for creating a post";
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
        return "create a post";
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}