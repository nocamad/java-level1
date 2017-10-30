package ru.geekbrains.java1.dz.dz3.TerehovAleksei;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //game1();
        game2();
    }

    //    Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
    //    попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
    //    указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    //    выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    private static void game1() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {//основное тело игры, начинаем игру и по окончании спрашиваем, повторить или нет
            System.out.println("Компьютер загадал число от 0 до 9");
            System.out.println("У вас три попытки, чтобы его отгадать");
            int number = random.nextInt(9);
            int count = 0;//счётчик попыток

            do {//цикл со счетчиком попыток
                System.out.println("Попытка " + (count + 1) + ". Введите число:");
                int result = scanner.nextInt();
                //проверяем, если отгадали, то выходим
                if (number == result) {
                    System.out.println("Вы отгадали! Поздравляем!");
                    break;
                }
                //проверяем, если закончились ли попытки, то выходим
                if (count == 2) {
                    System.out.println("Вы проиграли! Загаданное число равно " + number);
                    break;
                }
                //подсказываем
                if (number > result) {
                    System.out.println("Загаданное число больше");
                } else if (number < result) {
                    System.out.println("Загаданное число меньше");
                }

                count++;
            }
            while (true);
            System.out.println("Повторить игру? Да - 1, нет - 0");
        } while (scanner.nextInt() != 0);
    }

    //    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
//    слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    private static void game2() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //генерируем слово
        int wordNumber = random.nextInt(words.length);
        String word = words[wordNumber];

        //создаем слово которое, будет отображаться на экране
        char[] displayWordChar = new char[15];
        for (int i = 0; i < displayWordChar.length; i++) {
            displayWordChar[i] = '#';
        }

        //приветствие
        System.out.println("Компьютер загадал слово из списка " + Arrays.toString(words));
        System.out.println("Попробуйте отгадать");

        //цикл опроса пользователя
        int count = 1;
        do {
            System.out.println(displayWordChar);
            String result = scanner.nextLine();
            //проверка, на совпадение
            if (word.equals(result)) {
                System.out.println("Вы угадали!");
                break;
            }
            //проверка, на количество попыток
            if (count == word.length()) {
                System.out.println("Вы так и не угадали слово " + word);
                break;
            }
            //подсказываем, открываем по одной букве
            System.out.println("Подсказка:");
            for (int i = 0; i < count; i++) {
                displayWordChar[i] = word.charAt(i);
            }

            count++;
        } while (true);

    }
}
