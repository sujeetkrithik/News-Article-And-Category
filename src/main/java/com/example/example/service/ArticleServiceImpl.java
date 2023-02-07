package com.example.example.service;

import com.example.example.dto.ArticleRequest;
import com.example.example.dto.Response;
import com.example.example.entity.Article;
import com.example.example.entity.Category;
import com.example.example.repository.ArticleRepository;
import com.example.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{
    private ArticleRepository articleRepository;

    private CategoryRepository categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Article saveArticle(ArticleRequest articleRequest) {
        Category category = categoryRepository.findByCategoryName(articleRequest.getCategoryName());
        List<Article> articleList = category.getArticles();
        Article tempArticle = new Article();
        tempArticle.setTitle(articleRequest.getTitle());
        tempArticle.setDescription(articleRequest.getDescription());
        tempArticle.setCreationDateTime(String.valueOf(LocalDateTime.now()));
        articleList.add(tempArticle);
        categoryRepository.save(category);
        return tempArticle;
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    @Override
    public Article getArticleById(String id) throws Exception
    {
        Optional<Article> articleById=articleRepository.findById(id);
        if (articleById.isEmpty())
        {
            throw new Exception ("Article with the ID does not exist");
        }
        Article article = articleById.get();
        return article;
    }

    @Override
    public Article updateArticle(String id, ArticleRequest articleRequest)
    {
        Article savedArticle = new Article();
        Category category = categoryRepository.findByCategoryName(articleRequest.getCategoryName());
        List<Article> articleList = category.getArticles();
        for (Article article:articleList)
        {
            if (article.getId().equals(id))
            {
                article.setTitle(articleRequest.getTitle());
                article.setUpdationDateTime(String.valueOf(LocalDateTime.now()));
                article.setDescription(articleRequest.getDescription());
                savedArticle = article;
                categoryRepository.save(category);
            }
        }
        return savedArticle;
    }

    @Override
    public Response deleteArticleById(String id) throws Exception {
        Response response= new Response();
        Optional<Article> articleById = articleRepository.findById(id);
        if (articleById.isEmpty())
        {
            throw new Exception ("Article does not exist with the ID");
        }
        else
        {
            Optional<Article> articleByIdNew = articleRepository.findById(id);
            Article article=articleByIdNew.get();
            articleRepository.delete(article);
            response.setMessage("Action has been completed");
            return response;
        }

    }
}
