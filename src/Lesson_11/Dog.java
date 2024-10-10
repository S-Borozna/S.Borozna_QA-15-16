package Lesson_11;

public class Dog extends Animal {
    public static int counter = 0;
    private String name;

    public Dog(String name) {
        super();
        this.name = name;
        counter += 1;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 500) {
            System.out.println("Собака " + name + " пробежал " + obstacleLength + " метров");
        } else {
            System.out.println("Для собаки " + name + " это слишком большая дистанция.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        if (obstacleLength <= 10) {
            System.out.println("Собака " + name + " проплыл " + obstacleLength + " метров");
        } else {
            System.out.println("Для собаки " + name + " это слишком большая дистанция.");
        }
    }
}
