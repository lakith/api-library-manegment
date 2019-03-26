package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.Category;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.CategoryRepository;
import com.finalproj.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> saveCategory(Category category) {

        ResponseModel responseModel = new ResponseModel();
        category = categoryRepository.save(category);

        try {
            if (category != null) {
                responseModel.setMessage("Category Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save Category");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save Category");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateCategory(int categoryId, Category category) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

            if (!optionalCategory.isPresent()){
                responseModel.setMessage("There's No Category Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            category.setCategoryId(optionalCategory.get().getCategoryId());

            category = categoryRepository.save(category);

            if (category != null) {
                responseModel.setMessage("Category Details Updated Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }else{
                responseModel.setMessage("Failed To Update Category");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update Category");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getCategory(int categoryId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

            if (!optionalCategory.isPresent()){
                responseModel.setMessage("There's No Category  Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(optionalCategory.get(),HttpStatus.OK);


        } catch (Exception e) {
            responseModel.setMessage("Failed To Delete Category");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteCategory(int categoryId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

            if (!optionalCategory.isPresent()){
                responseModel.setMessage(" There's No Category Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            categoryRepository.deleteById(optionalCategory.get().getCategoryId());
            responseModel.setMessage("Category Removed Successfully");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Delete Category");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllCategories() {

        ResponseModel responseModel = new ResponseModel();

        try {
            List<Category> list= new ArrayList<>();
            list=categoryRepository.findAll();

            if (list.isEmpty()){
                responseModel.setMessage("Nothing  Found");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(list,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Nothing Found ");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }
}
