package ru.geekbrains.java1.lesson2;

/**
 * Created by Home-pc on 21.07.2016.
 */
public class Main {
    public static void main(String[] args) {
//        int u = 1; // создаем тестовую переменную
//        if (u > 1) { // если в u записано число больше 1
//            System.out.println("True"); // выполняем этот блок и выводим в консоль True
//        } else { // в противном случае
//            System.out.println("False"); // выполняем этот  и выводим в консоль False
//        }
//        if (u > 1 && u < 7) { // если число больше 1 И меньше 7
//            System.out.println("True");
//        }
//        if (u < 3 || u > 8) { // если число меньше 3 ИЛИ больше 8
//            System.out.println("True");
//        }
        // Блок switch
        int u = 2; // создаем тестовую переменную
        switch (u) {
            case 1: // Если u = 1
                System.out.println("u = one");
                break;
            case 2: // Если u = 2
                System.out.println("u = two");
                break;
            case 3: // Если u = 3
                System.out.println("u = three");
                break;
            default: // Если ни одно из условий выше не сработало
                System.out.println("u != 1, 2, 3");
        }
    }
}
