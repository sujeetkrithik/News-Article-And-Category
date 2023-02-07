package com.example.example.repository;

import com.example.example.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
    void delete(Category category);

    Category findByCategoryName(String categoryName);

    List<Category> findAll();
}
