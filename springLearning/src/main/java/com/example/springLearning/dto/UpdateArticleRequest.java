package com.example.springLearning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArticleRequest {

    private Long id;
    private String title;
    private String content;
}
