package com.example;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FelineTest {

    Feline feline = new Feline();

    @Test
    void testEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittensWithoutParams() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetKittensWithParams() {
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    void testGetFoodHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, feline.getFood("Травоядное"));
    }

    @Test
    void testGetFoodUnknownThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void testGetFoodPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.getFood("Хищник"));
    }
}