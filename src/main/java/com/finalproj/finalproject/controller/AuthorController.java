package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.Author;
import com.finalproj.finalproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping()
    public ResponseEntity<?> saveAuthor(@Valid @RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<?> updateAuthor(@Valid @PathVariable int authorId, @RequestBody Author author) {
        return authorService.updateAuthor(authorId,author);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int authorId) {
        return authorService.deleteAuthor(authorId);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<?> getAuthor(@PathVariable int authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping()
    public ResponseEntity<?> getAuthors() {
        return authorService.getAllAuthors();
    }

}
