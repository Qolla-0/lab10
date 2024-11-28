package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Arithmetic Operations")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @Description("Test for addition")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Addition")
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for subtraction")
    @Severity(SeverityLevel.NORMAL)
    @Story("Subtraction")
    public void testSubtract() {
        assertEquals(1.0, calculator.subtract(3.0, 2.0), 0.001);
    }

    @Test
    @Description("Test for multiplication")
    @Severity(SeverityLevel.MINOR)
    @Story("Multiplication")
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for division")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Division")
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for division by zero")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Division")
    public void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(5.0, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @Description("Test for square root calculation")
    @Severity(SeverityLevel.NORMAL)
    @Story("Square Root")
    public void testSqrt() {
        assertEquals(4.0, calculator.sqrt(16.0), 0.001);
    }

    /*
    @Test
    @Description("Test for square root of a negative number (should fail)")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Square Root")
    public void testSqrtOfNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.sqrt(-16.0)
        );
        assertEquals("Unexpected error message", exception.getMessage());
    }

    @Test
    @Description("Test for large division result (should fail)")
    @Severity(SeverityLevel.MINOR)
    @Story("Division")
    public void testDivideInfinityFailure() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.divide(1.0, 10.0), "This test is designed to fail.");
    }
     */
}
