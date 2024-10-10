package Lesson_11;

public class Cat extends Animal {
    public static int counter = 0;
    boolean satiety;
    int appetite;

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        counter += 1;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 200) {
            System.out.println("Кот " + name + " пробежал " + obstacleLength + " метров");
        } else {
            System.out.println("Для кота " + super.name + " это слишком большая дистанция.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Кот " + super.name + " не умеет плавать");
    }

    public void info() {
        System.out.println("Кот: " + name + " Аппетит: " + appetite + " Сытость: " + satiety);
    }

    public void eat(Bowl b) {
        if (!satiety) {
            if (b.devastation(appetite)) {
                System.out.println("Кот " + name + " поел. Теперь он сыт!");
                satiety = true;
            } else {
                System.out.println("Кот " + name + " не смог поесть. В миске не достаточно еды");
            }
        } else {
            System.out.println("Кот " + name + " не голоден.");
        }
    }
}
