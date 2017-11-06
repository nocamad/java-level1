package ru.geekbrains.java1.dz.dz5.TerehovAlexei;

public class Person {
    private String name;
    private String post;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String name, String post, String email, String phone, double salary, int age){
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    private void printInfoPerson(){
        System.out.println("Сотрудниик: "+name+", должность: "+post+", возраст: "+age+", email: "+email+", телефон: "+phone+", зарплата: "+salary);
    }

    public static void getOverAge(Person persons[], int age){
        for (int i = 0; i < persons.length; i++){
            if (persons[i].age > age){
                persons[i].printInfoPerson();
            }
        }
    }
}
