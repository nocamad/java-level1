package ru.geekbrains.java1.dz.dz6.DunaevArtur;

public class Dog extends Animal {

    private static final float MAX_RUN = 500;
    private static final float MAX_JUMP = 0.5f;
    private static final float MAX_SWIM = 10;

    @Override
    public void run(float f) {
        if (f <= (MAX_RUN * power)  && f > 0) {
            System.out.println("Собака " + name + " пробежала " + f + " метров");
        } else {
            System.out.println("Собака " + name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float f) {
        if (f <= (MAX_JUMP * power)  && f > 0) {
            System.out.println("Собака " + name + " прыгнула на " + f + " метров");
        } else {
            System.out.println("Собака " + name + " не может так прыгать");
        }
    }

    @Override
    public void swim(float f) {
        if (f <= (MAX_SWIM * power)  && f > 0) {
            System.out.println("Собака " + name + " проплыла " + f + " метров");
        } else {
            System.out.println("Собака " + name + " не может столько плавать");
        }
    }

    public Dog(String name, String color, float weight, float power) {
        super(name, color, weight, power);
    }

    @Override
    public void voice() {
        System.out.println(name + " лает");
    }

}
