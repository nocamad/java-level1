package ru.geekbrains.java1.lesson6.animals;

public  class Dog extends Animal {

    @Override
    public void voice() {
        System.out.println("лает");
    }

    public Dog(String name, String color, float weight) {
        super(name, color, weight);

    }



}
