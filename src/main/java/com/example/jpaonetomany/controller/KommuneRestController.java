package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.exception.ResourceNotFoundException;
import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repositories.KommuneRepository;
import com.example.jpaonetomany.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getkommuner")
    public List<Kommune> getKommunerApi() {
        return apiServiceGetKommuner.getKommuner();
    }

    @GetMapping("kommunenavn/{name}")
    public ResponseEntity<Kommune> getKommuneByName(@PathVariable String name) {
        Kommune kommune= kommuneRepository.findKommuneByNavn(name).orElseThrow(() -> new ResourceNotFoundException("Kommune ikke fundet med navn=" + name));
        return new ResponseEntity<>(kommune, HttpStatus.OK);
    }

    @GetMapping("/kommuner")
    public List<Kommune> getKommuner() {
        return kommuneRepository.findAll();
    }

    @PostMapping("/kommune")
    public ResponseEntity<Kommune> postRegion(@RequestBody Kommune kommune) {
        System.out.println("Indsætter ny Kommune");
        System.out.println(kommune);
        Kommune savedKommune = kommuneRepository.save(kommune);
        if (savedKommune == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(savedKommune, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/kommune/{kode}")
    public ResponseEntity<String> deleteKommune(@PathVariable String kode) {
        Optional<Kommune> kommune = kommuneRepository.findById(kode);
        if (kommune.isPresent()) {
            kommuneRepository.deleteById(kode);
            return ResponseEntity.ok("Kommune deleted");
        } else {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kommune not found");
        }
    }


}
