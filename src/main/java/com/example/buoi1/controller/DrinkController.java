package com.example.buoi1.controller;

import com.example.buoi1.model.Drink;
import com.example.buoi1.repo.DrinkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drinks")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkRepo drinkRepo;

    @GetMapping
    public List<Drink> getAll() {
        return drinkRepo.findAll();
    }

    @PostMapping
    public String addNewDrink(@RequestBody Drink drink) {
        drinkRepo.save(drink);
        return "Them thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteDrink(@RequestParam("id") Integer id) {
        drinkRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> update(@PathVariable Integer id, @RequestBody Drink d) {
        return drinkRepo.findById(id).map(item -> {
            item.setName(d.getName());
            item.setPrice(d.getPrice());
            item.setImage(d.getImage());
            item.setDescription(d.getDescription());
            item.setActive(d.getActive());
            if (d.getCategory() != null) item.setCategory(d.getCategory());
            return ResponseEntity.ok(drinkRepo.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }
}