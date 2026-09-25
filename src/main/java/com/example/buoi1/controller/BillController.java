package com.example.buoi1.controller;

import com.example.buoi1.model.Bill;
import com.example.buoi1.repo.BillRepo;
import com.example.buoi1.repo.DrinkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {
    private final BillRepo billRepo;

    @GetMapping("/bills")
    public List<Bill> getAll() {
        return billRepo.findAll();
    }

    @PostMapping("/bills")
    public String addNewBill(@RequestBody Bill bill) {
        billRepo.save(bill);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@RequestParam("id") Integer id) {
        billRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id")
    public ResponseEntity<Bill> update(@PathVariable Integer id, @RequestBody Bill b) {
        return billRepo.findById(id).map( item -> {
            item.setCode(b.getCode());
            item.setCreatedAt(b.getCreatedAt());
            item.setTotal(b.getTotal());
            item.setStatus(b.getStatus());
            if (b.getUser() != null) item.setUser(b.getUser());
            return ResponseEntity.ok(billRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }
}
