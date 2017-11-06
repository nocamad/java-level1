package ru.geekbrains.java1.lesson6;

import ru.geekbrains.java1.lesson6.animals.Animal;

/**
 * Created by i on 02.11.2017.
 */
public abstract class Typa2Animal extends Animal {
    public Typa2Animal(String name, String color, float weight) {
        super(name, color, weight);
        super.name = "dfh";
    }




}
