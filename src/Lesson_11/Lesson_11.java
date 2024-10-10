package Lesson_11;

public class Lesson_11 {
    public static void main(String[] args) {
        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Pups", 80);
        catArray[1] = new Cat("Mister", 65);
        catArray[2] = new Cat("Margarita", 95);
        catArray[3] = new Cat("Gleb", 120);
        catArray[4] = new Cat("Jozepa", 77);
        Dog dog1 = new Dog("Bobik");
        System.out.println(Animal.counter);
        System.out.println(Cat.counter);
        System.out.println(Dog.counter);
        dog1.swim(150);
        dog1.run(30);
        Bowl bowl1 = new Bowl(500);
        bowl1.replenishment(353);
        for (Cat cat : catArray) {
            cat.eat(bowl1);
        }
        bowl1.info();
        for (Cat cat : catArray) {
            cat.info();
        }

        Circle circle1 = new Circle(5);
        Rectangle r1 = new Rectangle(8, 6);
        Triangle triangle1 = new Triangle(5, 6, 5);
        circle1.setBorderColor("Black");
        circle1.setFillColor("White");
        r1.setBorderColor("Black");
        r1.setFillColor("White");
        triangle1.setBorderColor("Black");
        triangle1.setFillColor("White");
        circle1.info();
        r1.info();
        triangle1.info();
    }
}
