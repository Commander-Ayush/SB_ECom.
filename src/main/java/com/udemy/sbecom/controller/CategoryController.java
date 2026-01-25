package com.udemy.sbecom.controller;

import com.udemy.sbecom.model.Category;
import com.udemy.sbecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/api/public/categories")
    public String addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category Created";
    }

    @DeleteMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Long categoryId){
        try{
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new  ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }

    }

}
