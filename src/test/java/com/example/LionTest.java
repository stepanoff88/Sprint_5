package com.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline felineMock;

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}