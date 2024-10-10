package Lesson_11;

public class Animal {
    public static int counter = 0;
    String name;

    public Animal(String name) {
        this.name = name;
        counter += 1;
    }

    public void run(int obstacleLength) {
        System.out.println(name + " пробежал " + obstacleLength + " метров");
    }

    public void swim(int obstacleLength) {
        System.out.println(name + " проплыл " + obstacleLength + " метров");
    }
}
