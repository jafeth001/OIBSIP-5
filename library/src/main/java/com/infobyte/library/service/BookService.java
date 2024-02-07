package com.infobyte.library.service;

import com.infobyte.library.module.Book;
import com.infobyte.library.module.Category;
import com.infobyte.library.repository.BookRepository;
import com.infobyte.library.repository.CategoryRepository;
import com.infobyte.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
    final BookRepository bookRepository;
    final CategoryRepository categoryRepository;
    final UserRepository userRepository;

    public Book saveBook(Book book, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("category with " + id + " not found"));
        Book saveBook = Book.builder()
                .category(category)
                .name(book.getName())
                .author(book.getAuthor())
                .borrowed(false)
                .build();
        return bookRepository.save(saveBook);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("book with " + id + " not found"));
    }

    public Book borrowBook(Long id, Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user with " + userId + " not found"));
        var existBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("book with " + id + " not found"));
        existBook.setBorrowed(true);
        existBook.setBorrowedBy(user);
        return bookRepository.save(existBook);
    }

    public Book returnBook(Long id) {
        var existBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("book with " + id + " not found"));
        existBook.setBorrowed(false);
        existBook.setBorrowedBy(null);
        return bookRepository.save(existBook);
    }
}
