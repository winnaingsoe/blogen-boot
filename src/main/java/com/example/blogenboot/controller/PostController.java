package com.example.blogenboot.controller;

import com.example.blogenboot.ds.Category;
import com.example.blogenboot.service.BlogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "dashboard";
    }
    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "dashboard";
        }
        blogenService.saveCategory(category);
        return "redirect:/home";
    }

    @GetMapping("/list-categories")
    public String listAllCategories(Model model) {
        model.addAttribute("categories", blogenService.findAllCategories());
        return "list-categories";
    }
}
