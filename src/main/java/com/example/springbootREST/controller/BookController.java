package com.example.springbootREST.controller;
import com.example.springbootREST.dto.BookResponse;
import com.example.springbootREST.dto.BookCreateRequest;
import com.example.springbootREST.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookCreateRequest request) {
        BookResponse bookResponse = bookService.createBook(request);
        return ResponseEntity
                .created(URI.create("/{id}"))
                .body(bookResponse);
    }

    @GetMapping
    public Collection<BookResponse> getAllbooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        BookResponse bookResponse = this.bookService.getBookById(id);
        return ResponseEntity.ok(bookResponse);
    }
}