import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson_14Test {
    Lesson_14 calculator = new Lesson_14();

    @Test
    public void testFactorialForZero() {
        Assert.assertEquals(calculator.factorialCalculator(0), 1);
    }

    @Test
    public void testFactorialForOne() {
        Assert.assertEquals(calculator.factorialCalculator(1), 1);
    }

    @Test
    public void testFactorialForPositiveNumber() {
        Assert.assertEquals(calculator.factorialCalculator(7), 5040);
    }

    @Test
    public void testFactorialForNegativeNumber() {
        try {
            calculator.factorialCalculator(-1);
            Assert.fail("Ожидалось IllegalArgumentException для отрицательного числа");
        } catch (IllegalArgumentException ignored) {
        }
    }
}