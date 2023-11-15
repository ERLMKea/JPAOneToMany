package com.example.jpaonetomany.repositories;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Eriks simple test")
class KommuneRepositoryTest {

    @DisplayName("hard kod fail")
    @Test
    void test() {
        fail("det går ikke");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Disabled
    @Test
    void testDiv0() {
        int i = 0;
        int y = 10;
        assertEquals(0, y/i);
    }

    @DisplayName("Test array med Eriks avancerede sortering")
    @Test
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,5,12};
        Arrays.sort(numbers);
        //assertArrayEquals(expected, numbers);
        assertArrayEquals(expected, numbers, () -> "Sortering af 4 tal" + expected[1]);
    }


}