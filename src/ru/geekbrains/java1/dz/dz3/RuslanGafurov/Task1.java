package ru.geekbrains.java1.dz.dz3.RuslanGafurov;

import java.util.Random;
import java.util.Scanner;

//Игра Угадайка. Нужно угадать число от 0 до 9 за 3 попытки. После проигрыша или выигрыша возможно повторить игру.
//Введение некорректных значний (чисел больше, букв, пробелов, символов) потребует повторный ввод без потери попыток или ошибок.

public class Task1 {
    public static void main(String[] args) {
        do {
            boolean win = false;
            int mynumber = createNumberRandom();
            mainBoard();
            for (int attempt = 3; attempt > 0; attempt--) {
                int usernumber = gameInput(attempt);
                win = isCheckWin(usernumber, mynumber, attempt);
                if (win) {
                    isWin(attempt);
                    attempt = 0;
                }
            }
            if (!win) {
                System.out.println("Вы не угадали. Мое число было: " + mynumber);
            }
        } while (repeatGame());
    }

    //Заставка с правилами
    private static void mainBoard() {
        System.out.println(
                "\n-----------------------------------------\n" +
                        "|          Игра \"Угадайка\"              |\n" +
                        "|                                       |\n" +
                        "|  Правила: Загадано число от 0 до 9.   |\n" +
                        "| У Вас есть 3 попытки. Я вам подскажу. |\n" +
                        "|                                       |\n" +
                        "|                Удачи!!                |\n" +
                        "|                                       |\n" +
                        "-----------------------------------------\n");
    }

    //Вывод поздравления в зависимость от кол-во попыток
    private static void isWin(int a) {
        switch (a) {
            case 3: {
                System.out.println("С первой попытки. Вот это удача!! Может пора идти за лотерейным билетом?=)");
                break;
            }
            case 1: {
                System.out.println("На волоске, но это правильный ответ.");
                break;
            }
            default: {
                System.out.println("Вы угадали.");
            }
        }

    }

    //Генерация случайного числа от 0 до 9
    private static int createNumberRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    //Запрос на повторение игры
    private static boolean repeatGame() {
        int input = -1;
        String trash;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Повторить игру еще раз? 1-Да/0-Нет: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                trash = scanner.nextLine();
            }
            if (input == 1 || input == 0) {
                exit = true;
            } else {
                System.out.println("Упс... Я Вас не понял.");
            }
        } while (!exit);
        return (input == 1);
    }

    //Метод ввода числа игрока
    private static int gameInput(int attempt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        boolean exit = false, isint;
        String trash;
        do {
            isint = true;
            System.out.print("У Вас осталось " + attempt + " попытки(а).\n" + "Введите Ваше число: ");
            trash = scanner.nextLine();
            for (int s = 0; s < trash.length(); s++) {
                if ((int) trash.charAt(s) < 48 || (int) trash.charAt(s) > 57) {
                    isint = false;
                    break;
                }
            }
            if (isint) {
                if (trash.length() == 1) {
                    input = trash.charAt(0) - 48;
                    break;
                }
            }
            System.out.println("Упс... Вы ввели что-то не то.");

            //Алгоритм для чтения ввода. Не корректно работает при вводе 1й цифры, пробела и дальнейшего.
            //Пример: 5 ккпап - алгоритм возвращает 5, ввод считается корректным.
//            if (scanner.hasNextInt()) {
//                input = scanner.nextInt();
//            } else {
//                trash = scanner.nextLine();
//            }
//            if (input >= 0 && input <= 9) {
//                exit = true;
//            } else {
//                System.out.println("Упс... Вы ввели что-то не то.");
//            }
        } while (!exit);
        return input;
    }

    //Метод проверки загаданного и введенного числа
    private static boolean isCheckWin(int userNumber, int myNumber, int attempt) {
        if (userNumber == myNumber) {
            return true;
        }
        if (attempt > 1) {
            if (userNumber > myNumber) {
                System.out.print("Загаданное число меньше. ");
            } else {
                System.out.print("Загаданное число больше. ");
            }
        }

        return false;
    }
}
