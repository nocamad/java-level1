package ru.geekbrains.java1.lesson5;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(Cat.catsCount);
        Cat c1 = new Cat("Барсик", "Белый", 3, 2.0f);
        Cat c2 = new Cat("Мурзик", "Серый", 4, 3.0f);
//        c1.name = "vfdv";

//        String name = "gdfg";
//        if (name != null && name.length() > 4) {
//            c1.name = name;
//        }

        c1.getName();
        c1.setName("gdfg");
        {
            Cat c3 = new Cat();

            c1.printInfo();
            c2.printInfo();
            c3.printInfo();

            c1.meawoo();
            c2.meawoo();
            c3.meawoo();
            int i = 10;
            if (i == 10) {
                Cat c4 = new Cat();
                c4.printInfo();
            }
//            c4
        }
//        c3
        Cat[] cats = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat("Cat #" + i, "Color #" + i, i, (float) i);
            cats[i].printInfo();
        }
        System.out.println(Cat.catsCount);
    }
}
