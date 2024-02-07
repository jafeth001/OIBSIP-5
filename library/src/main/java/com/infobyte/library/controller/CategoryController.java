package com.infobyte.library.controller;

import com.infobyte.library.module.Category;
import com.infobyte.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    @GetMapping("/all")
    public List<Category> categories(){
        return categoryService.categories();
    }
    @GetMapping("/get")
    public Category getById(@RequestParam Long id){
        return categoryService.getById(id);
    }
}
