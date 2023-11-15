package com.example.jpaonetomany.repositories;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @DisplayName("paramtest med 3 arrays")
    @ParameterizedTest
    @MethodSource("sortnumbersArguments")
    void testArr(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af " + numbers.length + " tal");
    }

    private static Stream<Arguments> sortnumbersArguments() {
        return Stream.of(
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                Arguments.of(IntStream.of(8,1,2,3,5).toArray(), IntStream.of(1,2,3,15,8).toArray()),
                Arguments.of(IntStream.of(16,1,2,3).toArray(), IntStream.of(1,2,3,16).toArray())
        );
    }



}