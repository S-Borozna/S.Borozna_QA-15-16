package Lesson_10;

public class Lesson_10 {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Ivan", "Petrov", "Cook",
                "ip@gmail.com", 5556677, 8000, 24);
        employeesArray[1] = new Employee("Petr", "Ivuts", "Engineer",
                "PetrI@gmail.com", 4446677, 10000, 29);
        employeesArray[2] = new Employee("Murat", "Vetrov", "Lawyer",
                "Vetrov@gmail.com", 3336677, 14000, 35);
        employeesArray[3] = new Employee("Tina", "Leskova", "Financier",
                "TinaLes@gmail.com", 2226677, 18000, 22);
        employeesArray[4] = new Employee("Polina", "Klonova", "Cook",
                "KlonPol@gmail.com", 1116677, 9500, 26);
        Park park1 = new Park();
        Park.Attractions kolobok = new Park.Attractions("kolobok","09.00-21.00",150f);
        System.out.println(kolobok.getOpeningHours());
    }
}
