package com.example.jpaonetomany.repositories;

import com.example.jpaonetomany.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {
}
