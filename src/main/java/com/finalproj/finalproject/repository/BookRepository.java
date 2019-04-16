package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
