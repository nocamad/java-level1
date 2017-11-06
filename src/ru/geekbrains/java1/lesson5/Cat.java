package ru.geekbrains.java1.lesson5;

public class Cat {
    //private
    //default  - отсутствует
    //protected
    //public
    String name;
    private String color;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 4) {
            this.name = name;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public static int catsCount = 0; // статическая переменная для подсчета созданных котов

    public Cat(String name, String color, int age, float weight) { // Конструктор позволяет при создании объекта заполнить все необходимые поля
        this.name = name;
        this.color = color;
        this.age = age;

        catsCount++;
    }

    public Cat() { // Если разработчик указал пустой конструктор при создании объекта, поля заполнятся по умолчанию
        name = "Неизвестно";
        color = "Неизвестно";
        age = 1;

        catsCount++;
    }

    public void printInfo() { // Метод, с помощью которого производится вывод информации в консоль
        System.out.println("Имя: " + name + " Цвет: " + color + " Возраст: " + age );
    }

    public void meawoo() {

        System.out.println(name + " мяукает");
    }

}
