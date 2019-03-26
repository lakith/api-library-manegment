package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
