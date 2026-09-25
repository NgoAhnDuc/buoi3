package com.example.buoi1.controller;

import com.example.buoi1.model.User;
import com.example.buoi1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @PostMapping
    public String addNewUser(@RequestBody User user) {
        userRepo.save(user);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@RequestParam("id") Integer id) {
        userRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User u) {
        return userRepo.findById(id).map(item -> {
            item.setEmail(u.getEmail());
            item.setPassword(u.getPassword());
            item.setFullName(u.getFullName());
            item.setPhone(u.getPhone());
            item.setRole(u.getRole());
            item.setActive(u.getActive());
            return ResponseEntity.ok(userRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }
}
