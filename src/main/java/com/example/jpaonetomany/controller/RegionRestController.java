package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repositories.RegionRepository;
import com.example.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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

    @PostMapping("/region")
    public ResponseEntity<Region> postRegion(@RequestBody Region region) {
        System.out.println("Indsætter ny Region");
        System.out.println(region);
        Region savedRegion = regionRepository.save(region);
        if (savedRegion == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(savedRegion, HttpStatus.CREATED);
        }
    }

    @PutMapping("/region/{kode}")
    public ResponseEntity<Region> putRegion(@PathVariable String kode, @RequestBody Region region) {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if (orgRegion.isPresent()) {
            region.setKode(kode);
            regionRepository.save(region);
            return ResponseEntity.ok(region);
            //return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
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
