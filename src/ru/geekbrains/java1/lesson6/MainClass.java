package ru.geekbrains.java1.lesson6;


import ru.geekbrains.java1.lesson6.animals.*;

public class MainClass {

    public static void main(String[] args) {
        Animal[] animals = new Animal[3]; // создаем список животных
        animals[0] = new Cat("Барсик", "Белый", 2);
        animals[1] = new Dog("Бобик", "Черный", 2);
        animals[2] = new Horse("Алмаз", "Коричневый", 30);

//        Animal animal =  new Cat("Барсик", "Белый", 2);

        for (int i = 0; i < animals.length; i++) { // проходимся по всему списку
//            animals[i].printInfo();
            animals[i].voice(); // просим каждое животное подать голос
        }


        Cat c = (Cat)animals[0]; // Если нам нужны уникальные свойства кота, нужно сделать каст(cast)
        c.justCatMethod(); // После этого применить нужный метод


    }
}
