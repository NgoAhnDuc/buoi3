package com.example.buoi1.controller;

import com.example.buoi1.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkController {
    @Autowired
    DrinkRepo drinkRepo;

    @GetMapping("/drinks")
    public Object getAll() {
        return drinkRepo.findAll();
        }
}
