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
        stepPerformAddition(2.0, 3.0);
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for subtraction")
    @Severity(SeverityLevel.NORMAL)
    @Story("Subtraction")
    public void testSubtract() {
        stepPerformSubtraction(3.0, 2.0);
        assertEquals(1.0, calculator.subtract(3.0, 2.0), 0.001);
    }

    @Test
    @Description("Test for multiplication")
    @Severity(SeverityLevel.MINOR)
    @Story("Multiplication")
    public void testMultiply() {
        stepPerformMultiplication(2.0, 3.0);
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for division")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Division")
    public void testDivide() {
        stepPerformDivision(6.0, 3.0);
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
    }

    @Test
    @Description("Test for division by zero")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Division")
    public void testDivideByZero() {
        stepPerformDivisionByZero(5.0, 0);
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
        stepPerformSquareRoot(16.0);
        assertEquals(4.0, calculator.sqrt(16.0), 0.001);
    }

    @Test
    @Description("Test for invalid square root calculation")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Square Root")
    public void testSqrtOfNegative() {
        stepPerformInvalidSquareRoot(-16.0);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.sqrt(-16.0)
        );
        assertEquals("Cannot calculate square root of a negative number", exception.getMessage());
    }

    @Test
    @Description("Test for exponentiation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Exponentiation")
    public void testPower() {
        stepPerformExponentiation(2.0, 3.0);
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.001);
    }

    // Step definitions for Allure
    @Step("Perform addition of {a} and {b}")
    private void stepPerformAddition(double a, double b) {
        System.out.printf("Adding %.2f and %.2f%n", a, b);
    }

    @Step("Perform subtraction of {b} from {a}")
    private void stepPerformSubtraction(double a, double b) {
        System.out.printf("Subtracting %.2f from %.2f%n", b, a);
    }

    @Step("Perform multiplication of {a} and {b}")
    private void stepPerformMultiplication(double a, double b) {
        System.out.printf("Multiplying %.2f by %.2f%n", a, b);
    }

    @Step("Perform division of {a} by {b}")
    private void stepPerformDivision(double a, double b) {
        System.out.printf("Dividing %.2f by %.2f%n", a, b);
    }

    @Step("Attempt to divide {a} by {b} (division by zero)")
    private void stepPerformDivisionByZero(double a, double b) {
        System.out.printf("Attempting to divide %.2f by %.2f%n", a, b);
    }

    @Step("Calculate square root of {a}")
    private void stepPerformSquareRoot(double a) {
        System.out.printf("Calculating square root of %.2f%n", a);
    }

    @Step("Attempt to calculate square root of {a} (invalid input)")
    private void stepPerformInvalidSquareRoot(double a) {
        System.out.printf("Attempting to calculate square root of %.2f%n", a);
    }

    @Step("Raise {base} to the power of {exponent}")
    private void stepPerformExponentiation(double base, double exponent) {
        System.out.printf("Raising %.2f to the power of %.2f%n", base, exponent);
    }
}
