package ru.geekbrains.java1.lesson6.animals;
//     final
public       class Cat extends Animal {
    @Override
    public final void voice() {
        System.out.println(name + " мяукает");
    }


    @Override
    public void run(float f) {
        System.out.println("Кот " + name + " пробежал " + f + " метров");
    }

    public Cat(String name, String color, float weight) {
        super(name, color, weight);
//        super.name = "dfd";
//        weight++;

    }

    public void metod(float f, Integer[] i) {
final int d=10;

        i[0] +=  10;
        f++;
    }





    public void justCatMethod() {

        System.out.println("Вызов кошачего метода");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
