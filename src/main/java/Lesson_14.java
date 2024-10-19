public class Lesson_14 {
    public int factorialCalculator(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Для отрицательных чисел факториал определить нельзя!");
        } else if (a == 0 || a == 1) {
            return 1;
        } else {
            int result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Lesson_14 calculator = new Lesson_14();
        int num = 7;
        System.out.println("Факториал числа " + num + " равен " + calculator.factorialCalculator(num));
    }
}
