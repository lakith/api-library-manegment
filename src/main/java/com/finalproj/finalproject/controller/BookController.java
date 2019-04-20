package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.dto.BookDTO;
import com.finalproj.finalproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@Valid @PathVariable int bookId, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookId,bookDTO);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping()
    public ResponseEntity<?> getBooks() {
        return bookService.getAllBooks();
    }

}
