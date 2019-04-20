package com.finalproj.finalproject.service;

import com.finalproj.finalproject.dto.BookDTO;
import com.finalproj.finalproject.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {

    public ResponseEntity<?> saveBook(BookDTO bookDTO);
    public ResponseEntity<?> updateBook(int bookId,BookDTO bookDTO);
    public ResponseEntity<?> getBook(int bookId);
    public ResponseEntity<?> deleteBook(int bookId);
    public ResponseEntity<?> getAllBooks();

}
