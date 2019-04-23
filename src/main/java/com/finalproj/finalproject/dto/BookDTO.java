package com.finalproj.finalproject.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookDTO {

    private int bookId;
    @NotNull
    private String title;
    @NotNull
    private String isbnNumber;
    @NotNull
    private int year;
    @NotNull
    private double price;
    @NotNull
    private String publisher;
    @Pattern(regexp = "^(public|rare)$", message= "Input must be 'public' or 'rare'")
    private String status;
    @NotNull
    private int authorId;
    @NotNull
    private int categoryId;

    public BookDTO() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
