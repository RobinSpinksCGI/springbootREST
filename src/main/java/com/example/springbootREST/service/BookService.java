package com.example.springbootREST.service;

import com.example.springbootREST.dto.PaginatedResponse;
import com.example.springbootREST.model.Book;
import com.example.springbootREST.dto.BookResponse;
import com.example.springbootREST.dto.BookCreateRequest;
import com.example.springbootREST.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>() {{
        put(1L, new Book(1L, "Echoes of Tomorrow", "Mira Kessler", 18.99, "9781892456174"));
        put(2L, new Book(2L, "Whispers in the Fog", "Leonard Grant", 22.50, "9780553401399"));
        put(3L, new Book(3L, "The Clockmaker's Secret", "Mira Kessler", 16.75, "9783598320152"));
    }};
    private Long currentId = 4L;

    public Collection<BookResponse> getAllBooks() {
        return this.books.values().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    public Collection<BookResponse> getAllBooks(String author, Double maxPrice) {
        // complete
        return null;
    }

    public BookResponse getBookById(Long id) {
        Book book = this.books.get(id);
        BookResponse bookResponse = new BookResponse(book);
        return bookResponse;
    }

    public BookResponse createBook() {

        // complete
        return null;
    }

    public PaginatedResponse<BookResponse> getAllBooks(int page) {
        int pageSize = 2;
        Collection<BookResponse> allBooks = this.getAllBooks();

        // Calculate start and end indices
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, allBooks.size());

        // Check if the start index is valid
        if (start >= allBooks.size()) {
            return new PaginatedResponse<>(page, List.of()); // Return an empty list if the page is out of bounds
        }

        // Return a sublist for the given page
        return new PaginatedResponse<>(page, new ArrayList<>(allBooks).subList(start, end));

    }

}