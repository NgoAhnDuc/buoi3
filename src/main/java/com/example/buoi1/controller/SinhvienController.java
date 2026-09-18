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
        userList.add(new Sinhvien(1, "Ngo Anh Duc", "Ha Noi", "Male"));
        userList.add(new Sinhvien(2, "Nguyen Khanh Tung", "Ho Chi Minh City", "Famale"));
        userList.add(new Sinhvien(3, "Nguyen Ngoc Nam Khanh", "Da Nang City", "Male"));
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
                return "Update user success (khong can sua lai): " + sinhvien.getName();
            }
        }
        return "User not founddddd!!!!!!!";
    }

    @DeleteMapping("/delete-sinhvien/{id}")
    public String deleteUser(@PathVariable int id) {
        userList.removeIf(sinhvien -> sinhvien.getId() == id);
        return "Delete user success (khong can sua lai)";
    }
}