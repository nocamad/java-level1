package ru.geekbrains.java1.dz.dz5.lobysheva;

/*
 * Created by Oxana Lobysheva on 28/10/2017.
 */

public class Employer {

    private String name;
    private String position;
    private String email;
    private String telephone;
    private float salary;
    private int age;

    public Employer(String name, String position, String email, String telephone, float salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
        printPersonInfo();
    }

    public Employer(){
        this.name = "Unknown";
        this.position = "Unknown";
        this.email = "Unknown";
        this.telephone = "no telephone";
        this.salary = 0;
        this.age = 0;
        printPersonInfo();
    }

    public void printPersonInfo(){
        System.out.println();
        System.out.println("ФИО = " + name);
        System.out.println("Должность = " + position);
        System.out.println("Email = " + email);
        System.out.println("Телефон = " + telephone);
        System.out.println("Зарплата = " + salary);
        System.out.println("Возраст = " + age);
        System.out.println();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}