package com.example.buoi1.controller;

import com.example.buoi1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public Object getAll() {
        return userRepo.findAll();
    }
}
