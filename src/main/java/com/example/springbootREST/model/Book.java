package com.example.springbootREST.model;

import jakarta.validation.constraints.*;

public class Book {
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private final String title;

    @NotBlank(message = "Author cannot be blank")
    private final String author;

    @Min(value = 0, message = "Price cannot be negative")
    private final double price;

    @Pattern(regexp = "^[0-9]{13}$", message = "ISBN must be 13 digits")
    private final String isbn;

    public Book(Long id, String title, String author, double price, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getIsbn() { return isbn; }

    /**
     * Builder pattern implementation for creating Book instances.
     */
    public static class Builder {
        private Long id;
        private String title;
        private String author;
        private double price;
        private String isbn;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder author(String author) { this.author = author; return this; }
        public Builder price(double price) { this.price = price; return this; }
        public Builder isbn(String isbn) { this.isbn = isbn; return this; }

        public Book build() {
            return new Book(id, title, author, price, isbn);
        }
    }
}
