package com.example.buoi1.controller;

import com.example.buoi1.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final List<Users> userList = new ArrayList<>();

    public HomeController() {
        userList.add(new Users(1, "Ngo Anh Duc", "Ha Noi", "Male"));
        userList.add(new Users(2, "Nguyen Khanh Tung", "Ho Chi Minh City", "Famale"));
        userList.add(new Users(3, "Nguyen Ngoc Nam Khanh", "Da Nang City", "Male"));
    }

    @GetMapping("/list-users")
    public List<Users> listUsers() {
        return userList;
    }

    @PostMapping("/add-users")
    public String addUser(@RequestBody Users users) {
        userList.add(users);
        return "Add user success: " + users.getName();
    }

    @PutMapping("/update-users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Users users) {
        for (Users user : userList) {
            if (user.getId() == id) {
                user.setName(users.getName());
                return "Update user success (khong can sua lai): " + users.getName();
            }
        }
        return "User not founddddd!!!!!!!";
    }

    @DeleteMapping("/delete-users/{id}")
    public String deleteUser(@PathVariable int id) {
        userList.removeIf(user -> user.getId() == id);
        return "Delete user success (khong can sua lai)";
    }
}