package com.example.jpaonetomany.service;

import com.example.jpaonetomany.model.Kommune;

import java.util.List;

public interface ServiceKommuner {

    List<Kommune> getKommunerStartsWith(Character c);

}
