package com.example.example.controller;

import com.example.example.dto.ArticleRequest;
import com.example.example.dto.Response;
import com.example.example.entity.Article;
import com.example.example.repository.CategoryRepository;
import com.example.example.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    private CategoryRepository categoryRepository;

    private ArticleService articleService;

    public ArticleController(CategoryRepository categoryRepository, ArticleService articleService) {
        this.categoryRepository = categoryRepository;
        this.articleService = articleService;

    }

    @PostMapping("/article")
    public Article saveArticle(@RequestBody ArticleRequest articleRequest) {
        return articleService.saveArticle(articleRequest);
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable String id , @RequestBody ArticleRequest articleRequest)
    {
        return articleService.updateArticle(id,articleRequest);
    }


    @GetMapping("/article/{id}")
    public Article  getArticle(@PathVariable String id) throws Exception {
        return articleService.getArticleById(id);
    }

    @GetMapping("/article")
    public List<Article> getArticles()
    {
        return articleService.getArticles();
    }


    @DeleteMapping("/article/{id}")
    public Response deleteArticleById(@PathVariable String id) throws Exception {
        return articleService.deleteArticleById(id);
    }
}
