package com.udemy.sbecom.service;

import com.udemy.sbecom.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    void createCategory(Category category);

}
