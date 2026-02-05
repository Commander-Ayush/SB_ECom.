package com.udemy.sbecom.service;
 
import com.udemy.sbecom.model.Category;
import com.udemy.sbecom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    //List<Category> categories = new ArrayList<>();

    private static Long iDNumber = 1L;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @Override
//    public List<Category> getCategories() {
//        return categories;
//    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

//    @Override
//    public void createCategory(Category category) {
//        category.setCategoryId(iDNumber++);
//        categories.add(category);
//    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(iDNumber++);
        categoryRepository.save(category);
    }

//    @Override
//    public String deleteCategory(Long categoryId) {
//        Category categoryToBeDeleted = categories.stream()
//                .filter( c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found \n Please check the category you have entered"));
//        categories.remove(categoryToBeDeleted);
//        return "Category with CategoryID "+ categoryToBeDeleted.getCategoryId() + " has been deleted";
//    }

    @Override
    public String deleteCategory(Long categoryId) {

        List<Category> categories = categoryRepository.findAll();  //Added

        Category categoryToBeDeleted = categories.stream()
                .filter( c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found \n Please check the category you have entered"));

        categoryRepository.delete(categoryToBeDeleted);  // Changed
        return "Category with CategoryID "+ categoryToBeDeleted.getCategoryId() + " has been deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        List<Category> categories = categoryRepository.findAll();  //Added


        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category updatedCategory = categoryRepository.save(existingCategory);
            return updatedCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
