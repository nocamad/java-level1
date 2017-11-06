package ru.geekbrains.java1.lesson6.animals;

/**
 * Created by Home-pc on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {
//        Animal animal5 = new Animal("a", "red", 2);
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("cat", "red", 2);
        animals[1] = new Dog("Dog", "red", 2);
        animals[2] = new Horse("Horse", "red", 2);
//        animals[3] = animal5;
        for (Animal animal : animals) {
            animal.voice();
        }

        Animal animal2 = new Cat("cat", "red", 2);
        String s= "Барсик";
        float f =2;
        Integer i = new Integer(1000);
//        System.out.println(f);
//        System.out.println(i);
        Integer[] mas= {1,2};
        Cat cat =   new Cat(s, "Белый", f);

//        cat.voice();

//        cat.metod(f, mas);
//        System.out.println(f);
//        System.out.println(i);
//        System.out.println(Arrays.toString(mas));
//        Dog dog = new Dog();

    }
}
