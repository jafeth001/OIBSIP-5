package com.infobyte.library.controller;

import com.infobyte.library.module.Book;
import com.infobyte.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    public Book addBook(@RequestBody Book book, @RequestParam Long id) {
        return bookService.saveBook(book, id);
    }

    @GetMapping("all")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("get")
    public Book getBook(@RequestParam Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/borrow")
    public Book borrowBook(@RequestParam Long id, @RequestParam Long userId) {
        return bookService.borrowBook(id, userId);
    }

}
