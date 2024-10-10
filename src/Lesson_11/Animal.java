package Lesson_11;

public abstract class Animal {
    public static int counter = 0;

    public Animal() {
        counter += 1;
    }

    public abstract void run(int obstacleLength);

    public abstract void swim(int obstacleLength);
}
