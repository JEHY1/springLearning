package com.example.springLearning.dto;

import com.example.springLearning.domain.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}