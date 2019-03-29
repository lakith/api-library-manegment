package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Author;
import org.springframework.http.ResponseEntity;


public interface AuthorService {

    public ResponseEntity<?> saveAuthor(Author author);
    public ResponseEntity<?> updateAuthor(int authorId,Author author);
    public ResponseEntity<?> getAuthor(int authorId);
    public ResponseEntity<?> deleteAuthor(int authorId);
    public ResponseEntity<?> getAllAuthors();

}
