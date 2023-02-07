package com.example.example.controller;

import com.example.example.dto.Response;
import com.example.example.entity.Category;
import com.example.example.repository.CategoryRepository;
import com.example.example.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }


    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category)
    {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category category , @PathVariable String id) throws Exception {
        return categoryService.updateCategory(category,id);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable String id) throws Exception
    {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/category")
    public List<Category> getCategories()
    {
        return categoryService.getCategories();
    }

    @DeleteMapping("/category/{id}")
    public Response deleteCategoryById(@PathVariable String id) throws Exception
    {
        return categoryService.deleteCategoryById(id);
    }
}
