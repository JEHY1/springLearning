package com.example.springLearning.repository;

import com.example.springLearning.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
