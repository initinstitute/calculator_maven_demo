package com.example.calculator;

public class CalculatorService {

    public double calculate(double a, double b, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation must not be null.");
        }
        return switch (operation.toLowerCase()) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}
