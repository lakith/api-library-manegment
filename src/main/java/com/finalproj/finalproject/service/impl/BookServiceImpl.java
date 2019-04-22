package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.dto.BookDTO;
import com.finalproj.finalproject.model.Author;
import com.finalproj.finalproject.model.Book;
import com.finalproj.finalproject.model.Category;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.AuthorRepository;
import com.finalproj.finalproject.repository.BookRepository;
import com.finalproj.finalproject.repository.CategoryRepository;
import com.finalproj.finalproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;



    @Override
    public ResponseEntity<?> saveBook(BookDTO bookDTO) {

        ResponseModel responseModel = new ResponseModel();
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(bookDTO.getCategoryId());

            if (!optionalCategory.isPresent()){
                responseModel.setMessage(" There's No Category Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
            }

            Optional<Author> optionalAuthor = authorRepository.findById(bookDTO.getAuthorId());

            if (!optionalAuthor.isPresent()){
                responseModel.setMessage("There's No   Author Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            Book book= new Book();
            book.setTitle(bookDTO.getTitle());
            book.setIsbnNumber(bookDTO.getIsbnNumber());
            book.setYear(bookDTO.getYear());
            book.setPrice(bookDTO.getPrice());
            book.setPublisher(bookDTO.getPublisher());
            book.setStatus(bookDTO.getStatus());
            book.setCategory(optionalCategory.get());
            book.setAuthor(optionalAuthor.get());

            book=bookRepository.save(book);

            if (book != null) {
                responseModel.setMessage("Book Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save Book");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save Book");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> updateBook(int bookId, BookDTO bookDTO) {

        ResponseModel responseModel = new ResponseModel();
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(bookDTO.getCategoryId());

            if (!optionalCategory.isPresent()){
                responseModel.setMessage(" There's No Category Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
            }

            Optional<Author> optionalAuthor = authorRepository.findById(bookDTO.getAuthorId());

            if (!optionalAuthor.isPresent()){
                responseModel.setMessage("There's No Author Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            Optional<Book> optionalBook=bookRepository.findById(bookId);

            if (!optionalBook.isPresent()){
                responseModel.setMessage("There's No Book Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            Book book= new Book();
            book.setBookId(optionalBook.get().getBookId());
            book.setPublisher(bookDTO.getPublisher());
            book.setTitle(bookDTO.getTitle());
            book.setIsbnNumber(bookDTO.getIsbnNumber());
            book.setYear(bookDTO.getYear());
            book.setPrice(bookDTO.getPrice());
            book.setStatus(bookDTO.getStatus());
            book.setAuthor(optionalAuthor.get());
            book.setCategory(optionalCategory.get());


            book=bookRepository.save(book);

            if (book != null) {
                responseModel.setMessage("Book Detail Update Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Update Book");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update Book");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getBook(int bookId) {

        ResponseModel responseModel = new ResponseModel();
        try {
            Optional<Book> optionalBook=bookRepository.findById(bookId);

            if (!optionalBook.isPresent()){
                responseModel.setMessage(" There's No Book Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(optionalBook.get(),HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Filed To Get Details");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> deleteBook(int bookId) {

        ResponseModel responseModel = new ResponseModel();
        try {
            Optional<Book> optionalBook=bookRepository.findById(bookId);

            if (!optionalBook.isPresent()){
                responseModel.setMessage(" There's No Book Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            bookRepository.deleteById(optionalBook.get().getBookId());
            responseModel.setMessage("Book Deleted");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Filed To Delete Book");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllBooks() {
        ResponseModel responseModel = new ResponseModel();

        try {
            List<Book> list= new ArrayList<>();
            list=bookRepository.findAll();

            if (list.isEmpty()){
                responseModel.setStatus(false);
                responseModel.setMessage(" Nothing Found");
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(list,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Nothing Found ");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }
    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByTitle(String title) {
        List<Book> bookList = bookRepository.getBookByTitle(title);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByAuthorName(String name) {
        List<Book> bookList = bookRepository.getBookByAutherName(name);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByAuthorId(int authorId) {
        List<Book> bookList = bookRepository.getBookByAutherId(authorId);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByCaregoryId(int categoryId) {
        List<Book> bookList = bookRepository.getBookByCategoryId(categoryId);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByCaregoryName(String categoryName) {
        List<Book> bookList = bookRepository.getBookByCategoryName(categoryName);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBooksByYear(String year) {
        List<Book> bookList = bookRepository.getBookByYear(year);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getBookspublishType(String type) {
        List<Book> bookList = bookRepository.getBookByYear(type);
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
    }



}
