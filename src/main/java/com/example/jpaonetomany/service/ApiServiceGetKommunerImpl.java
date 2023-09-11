package com.example.jpaonetomany.service;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repositories.KommuneRepository;
import com.example.jpaonetomany.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner{

    @Autowired
    RegionRepository regionRepository;

    private final RestTemplate restTemplate;
    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    KommuneRepository kommuneRepository;

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    private void saveKommuneer(List<Kommune> kommuner) {
        kommuner.forEach(reg -> kommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner() {
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl,
                        HttpMethod.GET, null, new      ParameterizedTypeReference<List<Kommune>>(){
                        });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuneer(kommuner);
        return kommuner;
    }

}
