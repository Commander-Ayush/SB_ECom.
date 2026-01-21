package com.udemy.sbecom.service;

import com.udemy.sbecom.model.Category;
import org.springframework.stereotype.Service;

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
}
