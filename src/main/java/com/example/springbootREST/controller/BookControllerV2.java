package com.example.springbootREST.controller;

import com.example.springbootREST.dto.BookResponse;
import com.example.springbootREST.dto.PaginatedResponse;
import com.example.springbootREST.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v2/books")
public class BookControllerV2 {
    private final BookService bookService;

    public BookControllerV2(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public PaginatedResponse<BookResponse> getAllBooks(@RequestParam(defaultValue = "1") int page) {
        return bookService.getAllBooks(page);
    }
}
