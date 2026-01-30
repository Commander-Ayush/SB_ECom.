package com.udemy.sbecom.service;

import com.udemy.sbecom.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

}
