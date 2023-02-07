package com.example.example.service;

import com.example.example.dto.Response;
import com.example.example.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    // Save operation
    Category saveCategory(Category category);


    Category getCategoryById(String id) throws Exception;

    List<Category> getCategories();

    // Update operation
    Category updateCategory(Category category, String id) throws Exception;

    // Delete operation
    Response deleteCategoryById(String id) throws Exception;
}
