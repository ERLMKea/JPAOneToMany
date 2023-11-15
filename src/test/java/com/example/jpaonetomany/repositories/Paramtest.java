package com.example.jpaonetomany.repositories;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.service.ServiceKommuner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class Paramtest {

    @Autowired
    ServiceKommuner serviceKommuner;

    @ParameterizedTest
    @ValueSource(chars = {'B', 'D', 'G', 'R','K'}) // five letters
    void testLastDigitParam(char letter) {
        List<Kommune> kommuner = serviceKommuner.getKommunerStartsWith(letter);
        assertNotEquals(0, kommuner.size());
        assertEquals(true, kommuner.size()<100);
        Kommune kommune = kommuner.get(0);
        String str = kommune.getNavn();
        char firstLetter = str.substring(0,1).charAt(0);
        assertEquals(letter, firstLetter);
    }


}
