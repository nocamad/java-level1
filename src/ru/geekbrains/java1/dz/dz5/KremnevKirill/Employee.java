package ru.geekbrains.java1.dz.dz5.KremnevKirill;

public class Employee {
    private String name;
    private String position;
    private String email;
    private long tel;
    private int wages;
    private int age;

    public Employee(String name, String position, String email, long tel, int wages, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.wages = wages;
        this.age = age;
    }

    public void printInfo(){
        System.out.println(name + ", должность: " + position + ", email: " + email + ", телефон: " + tel + ", зарплата: " + wages + ", возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
