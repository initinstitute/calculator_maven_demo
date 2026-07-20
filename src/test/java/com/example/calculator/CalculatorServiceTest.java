package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAdd() {
        assertEquals(15.0, calculatorService.calculate(10, 5, "add"));
    }

    @Test
    void testSubtract() {
        assertEquals(5.0, calculatorService.calculate(10, 5, "subtract"));
    }

    @Test
    void testMultiply() {
        assertEquals(50.0, calculatorService.calculate(10, 5, "multiply"));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculatorService.calculate(10, 5, "divide"));
    }

    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(10, 0, "divide");
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
