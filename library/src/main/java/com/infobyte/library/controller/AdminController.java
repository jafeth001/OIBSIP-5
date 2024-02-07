package com.infobyte.library.controller;

import com.infobyte.library.module.Book;
import com.infobyte.library.module.User;
import com.infobyte.library.service.AdminService;
import com.infobyte.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final BookService bookService;

    @GetMapping("/users/all")
    public List<User> getById() {
        return adminService.getAllUsers();
    }

    @PutMapping("/update/book")
    public Book updateBook(@RequestParam Long id, @RequestBody Book book) {
        return adminService.updateBook(book, id);
    }

    @DeleteMapping("/delete/category")
    public String deleteCategory(@RequestParam Long id) {
        return adminService.deleteCategory(id);
    }

    @DeleteMapping("/delete/book")
    public String deleteBook(@RequestParam Long id) {
        return adminService.deleteBook(id);
    }

    @PutMapping("/return/book")
    public Book returnBook(@RequestParam Long id) {
        return bookService.returnBook(id);
    }
}
