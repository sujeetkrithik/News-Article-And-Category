package com.example.example.service;

import com.example.example.dto.ArticleRequest;
import com.example.example.dto.Response;
import com.example.example.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    // Save operation
    Article saveArticle(ArticleRequest articleRequest);

    // Read operation

    List<Article> getArticles();

    Article getArticleById(String id) throws Exception;

    Article updateArticle(String id, ArticleRequest articleRequest);

    // Delete operation

    Response deleteArticleById(String id) throws Exception;
}
