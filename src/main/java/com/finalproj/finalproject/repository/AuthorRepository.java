package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
