package com.finalproj.finalproject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finalproj.finalproject.dto.BookDTO;
import com.finalproj.finalproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping("/filter-by-title")
    public ResponseEntity<?> filterByTitle(@RequestParam("title") String title){
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/filter-by-author-name")
    public ResponseEntity<?> filterByAuthorName(@RequestParam("author-name") String authorName){
        return bookService.getBooksByTitle(authorName);
    }

    @GetMapping("/filter-by-author-id")
    public ResponseEntity<?> filterByAuthorId(@RequestParam("author-id") int authorId){
        return bookService.getBooksByAuthorId(authorId);
    }

    @GetMapping("/filter-by-category-id")
    public ResponseEntity<?> filterByCategoryId(@RequestParam("category-id") int categoryId){
        return bookService.getBooksByAuthorId(categoryId);
    }

    @GetMapping("/filter-by-category-name")
    public ResponseEntity<?> filterByCategoryName(@RequestParam("category-name") int categoryName){
        return bookService.getBooksByAuthorId(categoryName);
    }

    @GetMapping("/filter-by-year")
    public ResponseEntity<?> getBooksByYear(@RequestParam("year") String year){
        return bookService.getBooksByYear(year);
    }

    @GetMapping("/filter-by-publish-type")
    public ResponseEntity<?> getBookspublishType(@RequestParam("type") String type){
        return bookService.getBookspublishType(type);
    }

}
