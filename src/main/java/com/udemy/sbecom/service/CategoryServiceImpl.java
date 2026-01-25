package com.udemy.sbecom.service;

import com.udemy.sbecom.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categories = new ArrayList<>();

    private static Long iDNumber = 1L;

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(iDNumber++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category categoryToBeDeleted = categories.stream()
                .filter( c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found \n Please check the category you have entered"));
        categories.remove(categoryToBeDeleted);
        return "Category with CategoryID "+ categoryToBeDeleted.getCategoryId() + " has been deleted";
    }
}
