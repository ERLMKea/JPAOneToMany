package com.example.jpaonetomany.service;

import com.example.jpaonetomany.model.Region;

import java.util.List;

public interface ApiServiceGetRegioner {
    List<Region> getRegioner();
    List<String> getKommuneNavne(String regionKode);

}
