package com.example.jpaonetomany.repositories;

import com.example.jpaonetomany.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
}

