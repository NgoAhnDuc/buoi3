package com.example.buoi1.controller;

import com.example.buoi1.model.BillDetail;
import com.example.buoi1.repo.BillDetailRepo;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillDetailController {
    @Autowired
    BillDetailRepo billDetailRepo;

    @GetMapping("/billdetails")
    public List<BillDetail> getAll() {
        return billDetailRepo.findAll();
    }
}
