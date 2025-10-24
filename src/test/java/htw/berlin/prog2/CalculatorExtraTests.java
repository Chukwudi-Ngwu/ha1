package htw.berlin.prog2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CalculatorExtraTests {

    @Test
    void addition_simple_shouldPass() {
        Calculator calc = new Calculator();
        String result = calc.evaluate("2+3");
        assertEquals("5", result, "2+3 sollte 5 ergeben");
    }

    @Test
    void precedence_multiplication_before_addition_initially_mayFail() {
        Calculator calc = new Calculator();
        String result = calc.evaluate("2+3*4"); // korrekt: 14
        assertEquals("14", result, "2 + 3*4 sollte 14 ergeben (Multiplikation vor Addition)");
    }

    @Test
    void negative_and_decimal_numbers_initially_mayFail() {
        Calculator calc = new Calculator();
        String result = calc.evaluate("-2.5*4"); // korrekt: -10.0 (oder "-10")
        BigDecimal actual = new BigDecimal(result);
        assertEquals(0, actual.compareTo(new BigDecimal("-10.0")), " -2.5 * 4 sollte numerisch -10 ergeben");
    }
}