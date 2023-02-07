package com.example.example.repository;

import com.example.example.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String> {
    List<Article> findAll();

    void delete(Article article);
}
