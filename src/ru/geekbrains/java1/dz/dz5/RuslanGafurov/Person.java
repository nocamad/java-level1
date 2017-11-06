package ru.geekbrains.java1.dz.dz5.RuslanGafurov;

public class Person {

    private String fullname;
    private String position;
    private String email;
    private String phonenumber;
    private int salary;
    private int age;

    public Person(String fullname, String position, String email, String phonenumber, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("ФИО: "+fullname+"\nДолжность: "+position+"\nE-mail: "+email+"\nНомер телефона: "+
                phonenumber+ "\nЗарплата: "+salary+"\nВозраст: "+age);
    }

    public int getAge(){
        return age;
    }
}
