package ru.geekbrains.java1.dz.dz6.DunaevArtur;

import java.util.Scanner;

public class HomeWork6 {

    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли

    public static void main(String[] args) {

        // 1. Создать классы Собака и Кот с наследованием от класса Животное.
        Animal cat1 = new Cat("Васька", "черный", 2, 1);
        Animal dog1 = new Dog("Шарик", "серый", 4, 1);

        cat1.printInfo();
        dog1.printInfo();

        cat1.voice();
        dog1.voice();

        // 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра
        //    каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
        //    или высоту (для прыжков).

        // 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м.,
        //    собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).

        // 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
        //    (Например, dog1.run(150); -> результат: run: true)
        cat1.run(100);
        cat1.run(300);
        dog1.run(400);
        dog1.run(600);
        cat1.jump(1);
        cat1.jump(3);
        dog1.jump(0.4f);
        dog1.jump(1);
        cat1.swim(5);
        cat1.swim(1);
        dog1.swim(10);
        dog1.swim(15);

        // 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может
        //    быть 400 м., у другой 600 м.
        Animal cat2 = new Cat("Борис", "черный", 2, 1.1f);
        Animal dog2 = new Dog("Бобик", "серый", 4, 1.3f);
        Animal cat3 = new Cat("Самсон", "черный", 2, 0.8f);
        Animal dog3 = new Dog("Тузик", "серый", 4, 0.5f);

        System.out.println("Введите длину для бега: ");
        float length = sc.nextFloat();
        cat2.run(length);
        cat3.run(length);
        dog2.run(length);
        dog3.run(length);

        System.out.println("Введите высоту для прыжка: ");
        length = sc.nextFloat();
        cat2.jump(length);
        cat3.jump(length);
        dog2.jump(length);
        dog3.jump(length);

        System.out.println("Введите длину для плавания: ");
        length = sc.nextFloat();
        cat2.swim(length);
        cat3.swim(length);
        dog2.swim(length);
        dog3.swim(length);

    }

}
