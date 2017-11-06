package ru.geekbrains.java1.dz.dz5.DmitriiSimanushkin;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, int phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void employeeInfo() {
        System.out.println("Имя: " + fullName + "; Должность: " + position + "; Email: " + email + "; Номер телефона: " + phoneNumber + "; Зарплата: " + salary + "; Возраст: " + age);
    }
}
