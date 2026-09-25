package com.example.buoi1.controller;

import com.example.buoi1.model.BillDetail;
import com.example.buoi1.repo.BillDetailRepo;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billdetails")
@RequiredArgsConstructor
public class BillDetailController {
    private final BillDetailRepo billDetailRepo;

    @GetMapping("/billdetails")
    public List<BillDetail> getAll() {
        return billDetailRepo.findAll();
    }

    @PostMapping
    public String addNewBillDetail(@RequestBody BillDetail billDetail) {
        billDetailRepo.save(billDetail);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteBillDetail(@RequestParam("id") Integer id) {
        billDetailRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDetail> update(@PathVariable Integer id, @RequestBody BillDetail b) {
        return billDetailRepo.findById(id).map(item -> {
            item.setQuantity(b.getQuantity());
            item.setPrice(b.getPrice());
            if (b.getBill() != null) item.setBill(b.getBill());
            if (b.getDrink() != null) item.setDrink(b.getDrink());
            return ResponseEntity.ok(billDetailRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }

}
