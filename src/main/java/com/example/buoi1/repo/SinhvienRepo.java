package com.example.buoi1.repo;

import com.example.buoi1.model.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhvienRepo extends JpaRepository<Sinhvien, Integer> {
}
