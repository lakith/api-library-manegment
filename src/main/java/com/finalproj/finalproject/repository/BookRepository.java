package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Book;
import com.finalproj.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT b FROM Book b WHERE b.title=?1")
    List<Book> getBookByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.author.authorName=?1")
    List<Book> getBookByAutherName(String authorName);

    @Query("SELECT b FROM Book b WHERE b.author.authorId=?1")
    List<Book> getBookByAutherId(int authorId);

    @Query("SELECT b FROM Book b WHERE b.category.categoryId=?1")
    List<Book> getBookByCategoryId(int categoryId);

    @Query("SELECT b FROM Book b WHERE b.category.categoryName=?1")
    List<Book> getBookByCategoryName(String categoryName);

    @Query("SELECT b FROM Book b WHERE b.year=?1")
    List<Book> getBookByYear(String year);

    @Query("SELECT b FROM Book b WHERE b.status=?1")
    List<Book> getPublicOrRearBooks(String bookType);
}
