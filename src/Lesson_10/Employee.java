package Lesson_10;

public class Employee {
    String firstName;
    String lastName;
    String jobTitle;
    String email;
    int phone;
    int salary;
    int age;

    public Employee(String firstName, String lastName, String jobTitle, String email, int phone, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя:" + firstName +
                "\nФамилия:" + lastName +
                "\nДолжность:" + jobTitle +
                "\nEmail:" + email +
                "\nТелефон:" + phone +
                "\nЗарплата:" + salary +
                "\nВозраст:" + age);
    }
}
