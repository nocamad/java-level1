package ru.geekbrains.java1.lesson5;

public class Main {
    public static void main(String[] args) {
        String s = "string";

        Car lada = new Car();
        lada.setName("Lada samara");
        lada.setColor("red");
        lada.setNomer(7);
        lada.printInfo();
        lada.drive();


        Car volvo = new Car("Volvo C60", "green", 13);
        volvo.printInfo();
        volvo.drive();

        Car car4 = new Car("fff", "gg");
        car4.printInfo();
        car4.drive2("", "");

    }
}
