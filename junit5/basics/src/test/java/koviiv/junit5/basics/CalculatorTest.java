package koviiv.junit5.basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int expected = 2;
        int actual = calculator.add(1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void testComputeCircleArea() {
        Calculator calculator = new Calculator();
        double radiuss = 10d;
        double expectedCircleRadius = Math.PI * radiuss;
        double actualCircleRadius = calculator.computeCircleArea(radiuss);

        assertEquals(expectedCircleRadius, actualCircleRadius);
    }
}