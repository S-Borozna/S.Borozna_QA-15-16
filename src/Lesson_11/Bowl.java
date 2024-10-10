package Lesson_11;

public class Bowl {
    private static int counter;
    private int bowlId;
    private int capacity;
    private int completFood;

    public Bowl(int capacity) {
        this.capacity = capacity;
        counter += 1;
        bowlId = counter;
        completFood = 0;
    }

    public void info() {
        System.out.println("Миска: " + bowlId + " Вместимость: " + capacity + " грамм "
                + "Заполненно: " + completFood + " грамм");
    }

    public void replenishment(int grams) {
        if (completFood + grams <= capacity) {
            System.out.println("Корм в миску добавлен!");
            completFood += grams;
        } else {
            System.out.println("Невозможно добавить данное количество корма. Миска будет переполнена. " +
                    "Попробуй добавить " + (capacity - completFood) + " грамм корма");
        }
    }

    public boolean devastation(int n) {
        if (n <= completFood) {
            completFood -= n;
            return true;
        } else {
            return false;
        }
    }
}
