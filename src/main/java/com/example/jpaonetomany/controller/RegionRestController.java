package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repositories.RegionRepository;
import com.example.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @GetMapping("/regioner")
    public List<Region> getRegionerRepos() {
        return regionRepository.findAll();
    }

    @GetMapping("/kommunenavne/{kode}")
    public List<String> getKommuneNavne(@PathVariable String kode) {
        return apiServiceGetRegioner.getKommuneNavne(kode);
    }

    @DeleteMapping("/region/{kode}")
    public ResponseEntity<String> deleteStudent(@PathVariable String kode) {
        Optional<Region> region = regionRepository.findById(kode);
        if (region.isPresent()) {
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region deleted");
        } else {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }


}
