package ru.geekbrains.java1.dz.dz5.KopeikinAlexey;

public class Employees {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private Double salary;
    private int age;

    public Employees(String fio, String position, String email, String phone, Double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public void PRN() {
        System.out.print("ФИО: " + fio + " Должность: " + position + " e-mail:" + email + " телефон: " + phone + " Зарпата: " + salary + " Возраст: " + age);
        System.out.println();

    }

    public int getAge() {
        return age;

    }

}
