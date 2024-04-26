package com.example.springLearning.controller;

import com.example.springLearning.domain.Article;
import com.example.springLearning.dto.AddArticleRequest;
import com.example.springLearning.dto.RemoveArticleRequest;
import com.example.springLearning.dto.UpdateArticleRequest;
import com.example.springLearning.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public ResponseEntity<Article> save(@RequestBody AddArticleRequest request){
        Article article = articleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article);
    }

    @DeleteMapping("/article")
    public ResponseEntity<Void> remove(@RequestBody RemoveArticleRequest request){
        articleService.remove(articleService.findById(request.getId()));
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/article")
    public ResponseEntity<Article> update(@RequestBody UpdateArticleRequest request){
        Article article = articleService.update(request);
        return ResponseEntity.ok()
                .body(article);
    }

}
