package com.udemy.sbecom.service;

import com.udemy.sbecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private static Integer iDNumber = 0;

    List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    public String generateCategoryId(Category category) {
        iDNumber++;
        return category.getCategoryName().concat(iDNumber.toString());
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }
}
