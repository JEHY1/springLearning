package com.example.springLearning.service;

import com.example.springLearning.domain.Article;
import com.example.springLearning.dto.AddArticleRequest;
import com.example.springLearning.dto.UpdateArticleRequest;
import com.example.springLearning.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request){
        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(Long id){
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found articles"));
    }

    public void remove(Article article){
        articleRepository.delete(article);
    }

    @Transactional
    public Article update(UpdateArticleRequest request){
        Article article = articleRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("not found article"));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}