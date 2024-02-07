package com.infobyte.library.service;

import com.infobyte.library.module.Category;
import com.infobyte.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
