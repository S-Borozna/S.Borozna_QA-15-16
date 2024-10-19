import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lesson_14Test {
    Lesson_14 calculator = new Lesson_14();

    @Test
    @DisplayName("Проверка факториала числа 0")
    public void testFactorialForZero() {
        Assertions.assertEquals(calculator.factorialCalculator(0), 1);
    }

    @Test
    @DisplayName("Проверка факториала числа 1")
    public void testFactorialForOne() {
        Assertions.assertEquals(calculator.factorialCalculator(1), 1);
    }

    @Test
    public void testFactorialForPositiveNumber() {
        Assertions.assertEquals(calculator.factorialCalculator(7), 5040);
    }

    @Test
    @DisplayName("Проверка факториала отрицательного числа")
    public void testFactorialForNegativeNumber() {
        try {
            calculator.factorialCalculator(-1);
            Assertions.fail("Ожидалось IllegalArgumentException для отрицательного числа");
        } catch (IllegalArgumentException ignored) {
        }
    }
}