import org.example.mathFunctions.CalculatorLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {
    @Test
    public void testSum() {
        CalculatorLogic cl = new CalculatorLogic();
        double value1 = 5;
        double value2 = 4;

        final double result = cl.sumNumbers(value1, value2);

        final double expected = 5 + 4;
        assertEquals(expected, result);
    }

    @Test
    public void testSub() {
        CalculatorLogic cl = new CalculatorLogic();
        double value1 = 5;
        double value2 = 4;

        final double result = cl.subNumbers(value1, value2);

        final double expected = 5 - 4;
        assertEquals(expected, result);
    }

    @Test
    public void testDiv() {
        CalculatorLogic cl = new CalculatorLogic();
        double value1 = 5;
        double value2 = 4;

        final double result = cl.divNumbers(value1, value2);

        final double expected = 5 / 4.0;
        assertEquals(expected, result);
        assertThrows(IllegalArgumentException.class, () -> cl.divNumbers(value1, 0.0));
    }

    @Test
    public void testMul() {
        CalculatorLogic cl = new CalculatorLogic();
        double value1 = 5;
        double value2 = 4;

        final double result = cl.mulNumbers(value1, value2);

        final double expected = 5 * 4;
        assertEquals(expected, result);
    }
}
