package ru.geekbrains.java1.dz.dz5.EzhovAnton;


public class Personnel {
    private String name;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Personnel(String name, String post, String email, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Name: " + name + " Post: " + post + " Email: " + email + " Phone: " + phone + " Salary: " + salary + " getAge: " + age);
    }

    public int getAge() {
        return age;
    }
}
