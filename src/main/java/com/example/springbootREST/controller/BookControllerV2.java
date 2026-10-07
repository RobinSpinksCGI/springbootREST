package com.example.springbootREST.controller;

import com.example.springbootREST.dto.BookResponse;
import com.example.springbootREST.dto.PaginatedResponse;
import com.example.springbootREST.service.BookService;

public class BookControllerV2 {
    private final BookService bookService;

    public BookControllerV2(BookService bookService) {
        this.bookService = bookService;
    }

    // version
    public PaginatedResponse<BookResponse> getAllBooks(int page) {
        return bookService.getAllBooks(page);
    }
}
