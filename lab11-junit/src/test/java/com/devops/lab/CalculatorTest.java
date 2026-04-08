package com.devops.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(5,5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10,5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10,0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}