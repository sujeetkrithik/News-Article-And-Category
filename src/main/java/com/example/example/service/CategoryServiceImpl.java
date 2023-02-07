package com.example.example.service;

import com.example.example.dto.Response;
import com.example.example.entity.Category;
import com.example.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(String id) throws Exception {
        Optional<Category> tempCategoryById = categoryRepository.findById(id);
        if (tempCategoryById.isEmpty())
        {
            throw new Exception ("Category does not exist");
        }
        else
        {
            Category tempCategory = tempCategoryById.get();
            return  tempCategory;
        }
    }

    @Override
    public List<Category> getCategories()
    {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }


    @Override
    public Category updateCategory(Category category, String id) throws Exception {

        Optional<Category> tempCategoryById = categoryRepository.findById(id);
        if (tempCategoryById.isEmpty())
        {
            throw new Exception ("Category does not exist");
        }
        else
        {
            Category tempCategory = tempCategoryById.get();
            tempCategory.setCategoryName(category.getCategoryName());
            tempCategory.setArticles(category.getArticles());
            categoryRepository.save(tempCategory);
            return tempCategory;
        }

    }

    @Override
    public Response deleteCategoryById(String id) throws Exception {
        Response response=new Response();
        Optional<Category> categoryById = categoryRepository.findById(id);
        Category category = categoryById.get();

        categoryRepository.delete(category);
        response.setMessage("Action has been completed");
        return response;


    }
}
