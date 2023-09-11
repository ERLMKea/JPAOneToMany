package com.example.jpaonetomany.service;

import com.example.jpaonetomany.model.Region;
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
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {

    private final RestTemplate restTemplate;
    public ApiServiceGetRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    RegionRepository regionRepository;

    String regionUrl = "https://api.dataforsyningen.dk/regioner";


    @Override
    public List<String> getKommuneNavne(String regionKode) {
        Optional<Region> reg = regionRepository.findById(regionKode);
        List<String> navne = new ArrayList<>();
        if (reg.isPresent()) {
            navne = reg.get().getKommunenavne();
        }
        return navne;
    }


    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(reg -> regionRepository.save(reg));
    }

    @Override
    public List<Region> getRegioner() {
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionUrl,
                        HttpMethod.GET, null, new      ParameterizedTypeReference<List<Region>>(){
                        });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;
    }


}
