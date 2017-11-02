package ru.geekbrains.java1.dz.dz5.DunaevArtur;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printPersonCard() {
        System.out.println("Карточка сотрудника " + name + ":");
        System.out.println("---");
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.printf("Зарплата: %10.2f", salary);
        System.out.println();
        System.out.println("Возраст: " + age);
        System.out.println("---");
    }

    public void printSmallPersonCard() {
        System.out.println(name + " - " + age);
    }

    public int getAge() {
        return age;
    }
}
