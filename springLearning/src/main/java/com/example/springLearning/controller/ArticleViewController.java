package com.example.springLearning.controller;

import com.example.springLearning.dto.ArticleViewResponse;
import com.example.springLearning.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {

    private final ArticleService articleService;

    @GetMapping("/home")
    public String show(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "articles";
    }

    @GetMapping("/article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id != null) {
            ArticleViewResponse response = new ArticleViewResponse(articleService.findById(id));
            model.addAttribute("article", response);
        }
        else{
            model.addAttribute("article", new ArticleViewResponse());
        }
        return "newArticle";
    }
}