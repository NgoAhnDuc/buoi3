package com.example.buoi1.controller;

import com.example.buoi1.model.Category;
import com.example.buoi1.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/categories")
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
}
