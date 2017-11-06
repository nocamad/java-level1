package ru.geekbrains.java1.dz.dz6.DunaevArtur;

public abstract class Animal {
    protected String name;
    private String color;
    private float weight;
    protected float power;

    public abstract void run(float f);

    public abstract void jump(float f);

    public abstract void swim(float f);

    public void printInfo() {
        System.out.println("Имя: " + name + " Цвет: " + color + " Вес: " + weight + " кг.");
    }

    public abstract void voice();

    public Animal(String name, String color, float weight, float power) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
