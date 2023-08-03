import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorLogicTest {
    private static CalculatorLogic cl;
    @BeforeEach
    public void setUp(){
        cl = new CalculatorLogic();
    }
    @AfterEach
    public void tearDown(){
        cl = null;
    }
    @Test
    public void testSum() {
        //Given
        double value1 = 5;
        double value2 = 4;
        //When
        final double result = cl.sumNumbers(value1, value2);
        //Then
        final double expected = 5 + 4;
        assertEquals(expected, result);
    }

    @Test
    public void testSub() {
        //Given
        double value1 = 5;
        double value2 = 4;
        //When
        final double result = cl.subNumbers(value1, value2);
        //Then
        final double expected = 5 - 4;
        assertEquals(expected, result);
    }

    @Test
    public void testDiv() {
        //Given
        double value1 = 5;
        double value2 = 4;
        //When
        final double result = cl.divNumbers(value1, value2);
        //Then
        final double expected = 5 / 4.0;
        assertEquals(expected, result);
        assertThrows(IllegalArgumentException.class, () -> cl.divNumbers(value1, 0.0));
    }

    @Test
    public void testMul() {
        //Given
        double value1 = 5;
        double value2 = 4;
        //When
        final double result = cl.mulNumbers(value1, value2);
        //Then
        final double expected = 5 * 4;
        assertEquals(expected, result);
    }
}
