package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.Category;
import com.finalproj.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<?> saveCategory(@Valid @RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(@Valid @PathVariable int categoryId, @RequestBody Category category) {
        return categoryService.updateCategory(categoryId,category);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable int categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping()
    public ResponseEntity<?> getCategories() {
        return categoryService.getAllCategories();
    }

}
