package com.example.jpaonetomany.repositories;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.service.ServiceKommuner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestJPA {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ServiceKommuner serviceKommuner;

    @Test
    void test5Regioner() {
        List<Region> lstRegioner = regionRepository.findAll();
        assertEquals(5, lstRegioner.size());
    }

    @Test
    void test5Kommuner() {
        List<Kommune> lst = serviceKommuner.getKommunerStartsWith('V');
        assertEquals(7, lst.size());
    }

}
