package com.example.buoi1.repo;

import com.example.buoi1.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
}
