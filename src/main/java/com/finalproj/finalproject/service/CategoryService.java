package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    public ResponseEntity<?> saveCategory(Category category);
    public ResponseEntity<?> updateCategory(int categoryId,Category category);
    public ResponseEntity<?> getCategory(int categoryId);
    public ResponseEntity<?> deleteCategory(int categoryId);
    public ResponseEntity<?> getAllCategories();

}
