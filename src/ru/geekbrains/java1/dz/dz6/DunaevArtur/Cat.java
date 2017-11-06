package ru.geekbrains.java1.dz.dz6.DunaevArtur;

public class Cat extends Animal {

    private static final float MAX_RUN = 200;
    private static final float MAX_JUMP = 2;
    private static final float MAX_SWIM = 0;

    @Override
    public void run(float f) {
        if (f <= (MAX_RUN * power)  && f > 0) {
            System.out.println("Кот " + name + " пробежал " + f + " метров");
        } else {
            System.out.println("Кот " + name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float f) {
        if (f <= (MAX_JUMP * power)  && f > 0) {
            System.out.println("Кот " + name + " прыгнул на " + f + " метров");
        } else {
            System.out.println("Кот " + name + " не может так прыгать");
        }
    }

    @Override
    public void swim(float f) {
        System.out.println("Коты не умеют плавать");
    }

    public Cat(String name, String color, float weight, float power) {
        super(name, color, weight, power);
    }

    @Override
    public void voice() {
        System.out.println(name + " мяукает");
    }
}
