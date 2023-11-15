package com.example.jpaonetomany.service;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.repositories.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceKommunerImpl implements ServiceKommuner {

    @Autowired
    KommuneRepository kommuneRepository;

    @Override
    public List<Kommune> getKommunerStartsWith(Character c) {
        return kommuneRepository.findAll().stream().filter(kom -> kom.getNavn().charAt(0) == c).collect(Collectors.toList());
    }

}
