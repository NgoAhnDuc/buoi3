package com.example.buoi1.controller;

import com.example.buoi1.model.Bill;
import com.example.buoi1.repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    BillRepo billRepo;

    @GetMapping("/bills")
    public List<Bill> getAll() {
        return billRepo.findAll();
    }
}
