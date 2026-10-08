package com.example.springbootREST.controller;
import com.example.springbootREST.dto.BookResponse;
import com.example.springbootREST.dto.BookCreateRequest;
import com.example.springbootREST.service.BookService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Collection<BookResponse> getAllbooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return this.bookService.getBookById(id);
    }
}