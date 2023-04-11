package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostRepository;
import com.codeup.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    @GetMapping("/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("post") Post post) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(loggedInUser);
        postsDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/{postId}/edit")
    public String editPost(@PathVariable long postId, Model model) {
        Post post = postsDao.findById(postId).get();
        model.addAttribute("post", post);
//        return "posts/edit";
        return "posts/create";
    }



    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable long postId, Model model) {
        Post post = postsDao.findById(postId).get();
        model.addAttribute("post", post);
        return "posts/Delete";
    }

    @PostMapping("/{postId}/delete")
    public String deletePost(@PathVariable long postId, @ModelAttribute("post") Post post) {
        Post testPost = postsDao.findById(postId).get();
        postsDao.deleteById(testPost.getId());
        return "redirect:/posts";
    }

    @GetMapping
    public String allPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "user/index";
    }

    @GetMapping("/{postId}")
    public String viewPost(@PathVariable long postId, Model model) {
        Post testPost = postsDao.findById(postId).get();
        model.addAttribute("post", testPost);
        return "posts/Show";
    }
//    @GetMapping("post/{id}/edit")
//    public String showEditPostForm(@PathVariable long id, Model model) {
//        Post testpost = postDao.findById(id).get();
//        model.addAttribute("post", testpost);
//        return "posts/edit";
//    }
//    @PostMapping("post/{id}/edit")
//    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
//        Post Post = postDao.findById(id).get();
//        post.setId(post.getId());
//        post.setUser(Post.getUser());
//        postDao.save(post);
//        return "redirect:/posts/{id}";
//    }
}