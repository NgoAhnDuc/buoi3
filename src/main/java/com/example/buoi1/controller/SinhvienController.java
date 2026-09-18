package com.example.buoi1.controller;

import com.example.buoi1.model.Sinhvien;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SinhvienController {

    private final List<Sinhvien> userList = new ArrayList<>();

    public SinhvienController() {
        userList.add(new Sinhvien(1, "Ngo Anh Duc", "Ha Noi City", "Nam", "Dang hoc"));
        userList.add(new Sinhvien(2, "Nguyen Khanh Tung", "Ho Chi Minh City", "Nu", "Di hoc"));
        userList.add(new Sinhvien(3, "Nguyen Ngoc Nam Khanh", "Da Nang City", "Nam", "Di hoc"));
    }

    @GetMapping("/list-sinhvien")
    public List<Sinhvien> listUsers() {
        return userList;
    }

    @PostMapping("/add-sinhvien")
    public String addUser(@RequestBody Sinhvien sinhvien) {
        userList.add(sinhvien);
        return "Add user success: " + sinhvien.getName();
    }

    @PutMapping("/update-sinhvien/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Sinhvien sinhvien) {
        for (Sinhvien existingSinhvien : userList) {
            if (existingSinhvien.getId() == id) {
                existingSinhvien.setName(sinhvien.getName());
                existingSinhvien.setAddress(sinhvien.getAddress());
                existingSinhvien.setGender(sinhvien.getGender());
                existingSinhvien.setStatus(sinhvien.getStatus());
                return "Update user success: " + sinhvien.getName();
            }
        }
        return "User not found with id: " + id;
    }

    @DeleteMapping("/delete-sinhvien/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean removed = userList.removeIf(sinhvien -> sinhvien.getId() == id);
        if (removed) {
            return "Delete user success with id: " + id;
        }
        return "User not found with id: " + id;
    }
}