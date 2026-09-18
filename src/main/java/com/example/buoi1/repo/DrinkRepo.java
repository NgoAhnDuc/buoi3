package com.example.buoi1.repo;

import com.example.buoi1.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
}
