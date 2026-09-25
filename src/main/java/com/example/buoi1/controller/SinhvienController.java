package com.example.buoi1.controller;

import com.example.buoi1.model.Sinhvien;
import com.example.buoi1.repo.SinhvienRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sinhvien")
@RequiredArgsConstructor
public class SinhvienController {
    private final SinhvienRepo sinhvienRepo;

    @GetMapping
    public List<Sinhvien> getAll() {
        return sinhvienRepo.findAll();
    }

    @PostMapping
    public String addNewSinhvien(@RequestBody Sinhvien sinhvien) {
        sinhvienRepo.save(sinhvien);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteSinhvien(@RequestParam("id") Integer id) {
        sinhvienRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinhvien> update(@PathVariable Integer id, @RequestBody Sinhvien s) {
        return sinhvienRepo.findById(id).map(item -> {
            item.setName(s.getName());
            item.setAddress(s.getAddress());
            return ResponseEntity.ok(sinhvienRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }

}