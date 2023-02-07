package com.example.example.dto;

import lombok.Data;

@Data
public class ArticleRequest {
    private String categoryName;
    private String title;
    private String description;
}
