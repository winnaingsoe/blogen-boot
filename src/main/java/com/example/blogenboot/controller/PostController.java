package com.example.blogenboot.controller;

import com.example.blogenboot.ds.Category;
import com.example.blogenboot.ds.Post;
import com.example.blogenboot.ds.User;
import com.example.blogenboot.service.BlogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private BlogenService blogenService;
    @GetMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("user", new User());
        model.addAttribute("post", new Post());
        return "dashboard";
    }
    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "dashboard";
        }
        blogenService.saveCategory(category);
        return "redirect:/list-categories";
    }

    @PostMapping("/save-user")
    public String saveUser(User user, BindingResult result) {
        if(result.hasErrors()) {
            return "dashboard";
        }
        blogenService.saveUser(user);
        return "redirect:/list-users";
    }
    @PostMapping("/save-post")
    public String savePost(Post post, BindingResult result) {
        if(result.hasErrors()) {
            return "dashboard";
        }
        blogenService.savePost(post);
        return "redirect:/list-posts";
    }

    @GetMapping("/list-categories")
    public String listAllCategories(Model model, @ModelAttribute("categories") List<Category> categories) {
        model.addAttribute("categories", categories);
        return "list-categories";
    }
    @GetMapping("/list-users")
    public String listAllUsers(Model model, @ModelAttribute("users") List<User> users) {
        model.addAttribute("users", users);
        return "list-users";
    }
    @GetMapping("/list-posts")
    public String listAllPosts(Model model, @ModelAttribute("posts") List<Post> posts) {
        model.addAttribute("posts", posts);
        return "list-posts";
    }
    @ModelAttribute("categories")
    public List<Category> listCategories() {
        return blogenService.findAllCategories();
    }
    @ModelAttribute("users")
    public List<User> listUsers() {
        return blogenService.findAllUsers();
    }
    @ModelAttribute("posts")
    public List<Post> listPosts() {
        return blogenService.findAllPosts();
    }
}
