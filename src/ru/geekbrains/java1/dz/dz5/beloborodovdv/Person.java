package ru.geekbrains.java1.dz.dz5.beloborodovdv;

public class Person {
    private String fio;
    private String office;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Person(String fio, String office, String email, String telephone, int salary, int age) {
        this.fio = fio;
        this.office = office;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fio);
        System.out.println("должность: " + office);
        System.out.println("email: " + email);
        System.out.println("telephone: " + telephone);
        System.out.println("salary: " + salary);
        System.out.println("age: +" + age);
       System.out.println();

    }

    ;


}
