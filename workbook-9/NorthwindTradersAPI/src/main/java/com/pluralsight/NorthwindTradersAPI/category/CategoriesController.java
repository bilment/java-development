package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private List<Category> categories = new ArrayList<>();

    public CategoriesController() {
        categories.add(new Category(1, "Category A"));
        categories.add(new Category(2, "Category B"));
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categories.stream()
                .filter(category -> category.getCategoryId() == id)
                .findFirst()
                .orElse(null);
    }
}
