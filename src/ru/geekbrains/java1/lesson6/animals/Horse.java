package ru.geekbrains.java1.lesson6.animals;

public final class Horse extends Animal {

    public Horse(String name, String color, float weight) {
        super(name, color, weight);
    }

    @Override
    public void voice() {
        System.out.println(name + " ржет");
    }

}
