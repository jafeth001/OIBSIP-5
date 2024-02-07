package com.infobyte.library.service;

import com.infobyte.library.module.Book;
import com.infobyte.library.module.User;
import com.infobyte.library.repository.BookRepository;
import com.infobyte.library.repository.CategoryRepository;
import com.infobyte.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteBook(Long id) {
         bookRepository.deleteById(id);
         return "deleted successfully";
    }

    public Book updateBook(Book book, Long id) {
        Book existBook = bookRepository.findById(id).get();
        if (Objects.nonNull(book.getName())&&!"".equalsIgnoreCase(book.getName())){
            existBook.setName(book.getName());
        }  if (Objects.nonNull(book.getAuthor())&&!"".equalsIgnoreCase(book.getAuthor())){
            existBook.setAuthor(book.getAuthor());
        }
        return bookRepository.save(existBook);
    }

    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
