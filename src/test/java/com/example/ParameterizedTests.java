package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParameterizedTests {

    @Mock
    Feline felineMock;

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testLionSexParameterized(String sex) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        if ("Самец".equals(sex)) {
            assertEquals(true, lion.doesHaveMane());
        } else {
            assertEquals(false, lion.doesHaveMane());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void testGetKittensParameterized(int count) {
        when(felineMock.getKittens(count)).thenReturn(count);
        assertEquals(count, felineMock.getKittens(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void testGetFoodParameterized(String animalKind) throws Exception {
        Feline feline = new Feline();
        if ("Травоядное".equals(animalKind)) {
            assertEquals(List.of("Трава", "Различные растения"), feline.getFood(animalKind));
        } else if ("Хищник".equals(animalKind)) {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood(animalKind));
        }
    }
}