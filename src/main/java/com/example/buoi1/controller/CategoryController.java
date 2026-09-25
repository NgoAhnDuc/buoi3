package com.example.buoi1.controller;

import com.example.buoi1.model.Category;
import com.example.buoi1.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepo categoryRepo;

    @GetMapping
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @PostMapping
    public String addNewCategory(@RequestBody Category category) {
        categoryRepo.save(category);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@RequestParam("id") Integer id) {
        categoryRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category c) {
        return categoryRepo.findById(id).map(item -> {
            item.setName(c.getName());
            item.setActive(c.getActive());
            return ResponseEntity.ok(categoryRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }
}
