package ru.geekbrains.java1.lesson5;

/**
 * Created by i on 30.10.2017.
 */
public class Car {
    private String name;
    private String color;
    private int nomer;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public Car(String name, String color, int nomer) {
        this(name, color);
        this.nomer = nomer;
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Car() {
    }


    public void printInfo() {
        System.out.println("name: " + name + " color: " + color + " nomer: " + nomer);
    }

    public void drive() {
        System.out.println(name + " drive");
    }

    public void drive2(String ... s) {
    }

    public void drive2(String  s, String g) {
    }



}
