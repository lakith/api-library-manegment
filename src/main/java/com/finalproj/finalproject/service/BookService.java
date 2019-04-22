package com.finalproj.finalproject.service;

import com.finalproj.finalproject.dto.BookDTO;
import com.finalproj.finalproject.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {

    ResponseEntity<?> saveBook(BookDTO bookDTO);
    ResponseEntity<?> updateBook(int bookId,BookDTO bookDTO);
    ResponseEntity<?> getBook(int bookId);
    ResponseEntity<?> deleteBook(int bookId);
    ResponseEntity<?> getAllBooks();
    ResponseEntity<?> getBookspublishType(String type);
    ResponseEntity<?> getBooksByYear(String year);
    ResponseEntity<?> getBooksByCaregoryName(String categoryName);
    ResponseEntity<?> getBooksByCaregoryId(int categoryId);
    ResponseEntity<?> getBooksByAuthorId(int authorId);
    ResponseEntity<?> getBooksByAuthorName(String name);
    ResponseEntity<?> getBooksByTitle(String title);

}
