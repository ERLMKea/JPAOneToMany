package com.example.jpaonetomany.mocking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MockTest {

    @Test
    void testMock1() {
        Map mapMock = mock(Map.class);
        mapMock.put(1085, "Roskilde"); //size af mapMock er 0 efter denne linje
        Object obj = mapMock.get(1085); //obj er null
        System.out.println(obj);
        assertEquals("Roskilde", "" + obj);
    }

    @Test
    void testMock2() {
        Map mapMock = mock(Map.class);
        //mapMock.put(1085, "Roskilde");
        when(mapMock.get(1085)).thenReturn("Roskilde");
        assertEquals("Roskilde", mapMock.get(1085));


    }

    @DisplayName("mock size")
    @Test
    void testListThen() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @DisplayName("først 2 så 3")
    @Test
    void testListThenThen() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3); //first time called return 2, second time return 3
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }



}
