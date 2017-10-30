package ru.geekbrains.java1.dz.dz3.RoumyantsevPA;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//      1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
// это число. При каждой попытке компьютер должен сообщить больше лиуказанное пользователем число, чем загаданное, или
// меньше. После победы или проигрышавыводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
// (1 – повторить, 0 – нет).


        Game1();

//      2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
// "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
// "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};При запуске программы компьютер загадывает слово,
// запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
// Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.

        Game2();
    }

    public static void Game1() {
        cls();
        int t = 3;
        Scanner scanner = new Scanner(System.in);
        int b = 0;
        Random random = new Random();
        int a = random.nextInt(9);
        System.out.println("Загадано случайное число от 0 до 9.");
        for (; ; ) {

            System.out.printf("Угадайте это число.. Осталось попыток %d\n", t);
            b = scanner.nextInt();
            if (a == b) {
                System.out.println("Вы угадали!\n «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)\n");
                b = scanner.nextInt();
                if (b == 1) {
                    t = 3;
                    a = random.nextInt(9);
                } else {
                    return;
                }
            } else {
                t--;
                if (t <= 0) {
                    System.out.println("Вы проиграли!\n «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)\n");
                    b = scanner.nextInt();
                    if (b == 1) {
                        t = 3;
                        a = random.nextInt(9);
                        cls();
                        System.out.println("Загадано случайное число от 0 до 9.");
                    } else {
                        return;
                    }
                } else {
                    if (b > a) {
                        System.out.println("Меньше!");
                    } else {
                        System.out.println("Больше!");
                    }
                }
            }
        }
    }

    public static void cls() {
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
    }

    public static void Game2() {
        cls();
        System.out.println("«Выберете язык игры en – английский / ru – русский»");
        Scanner scanner = new Scanner(System.in);
        String b = "";
        // b = scanner.next();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leaf", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String[] words2 = {"яблоко", "апельсин", "лимон", "банан", "абрикос", "авокадо", "брокколи", "морковь",
                "вишня", "чеснок", "виноград", "дыня", "лист", "киви", "манго", "гриб", "орех", "оливка", "горох",
                "арахис", "груша", "перец", "ананас", "тыква", " картофель"};
        int s = 0;
        for (; ; ) {
            b = scanner.next();
            switch (b) {
                case "ru":
                    printFood(words2);
                    s = 1;
                    break;
                case "en":
                    printFood(words);
                    s = 1;
                    break;
                default:
                    System.out.println("Ошибка, еще раз: en – английский / ru – русский");
            }
            if (s == 1) {
                break;
            }
        }
        System.out.println("\n \n Угадайте слово:");
        String a = "";
        String answer = "";
        Random random = new Random();
        if (b.equals("ru")) {
            answer = words2[random.nextInt(words2.length)];
        } else {
            answer = words[random.nextInt(words.length)];
        }
//        System.out.println("Загадали: " + answer);
        for (; ; ) {
            a = scanner.next();
            if (a.equals(answer)) {
                System.out.println("Вы угадали!!!");
                System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)\n");
                s = 0;
                s = scanner.nextInt();
                if (s == 1) {
                    if (b.equals("ru")) {
                        answer = words2[random.nextInt(words2.length)];
                        cls();
                        printFood(words2);
                    } else {
                        answer = words[random.nextInt(words.length)];
                        cls();
                        printFood(words);
                    }
                    System.out.println("\n \n Угадайте слово:");
                } else {
                    break;
                }
            } else {
                for (int i = 0; i < 15; i++) {
                    if (i < answer.length() && i < a.length()) {
                        if (answer.charAt(i) == a.charAt(i)) {
                            System.out.print(a.charAt(i));
                        } else {
                            System.out.print('#');
                        }
                    } else {
                        System.out.print('#');
                    }
                }
            }
            System.out.println("");

        }


//        System.out.println(Arrays.toString(words));
//        System.out.println(Arrays.toString(words2));

    }

    public static void printFood(String[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
            counter++;
            if (counter >= 5) {
                System.out.println("");
                counter = 0;
            }

        }
    }
}
