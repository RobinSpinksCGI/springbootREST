package com.example.springbootREST.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find a book with id: "+id);
    }
}