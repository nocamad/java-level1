package ru.geekbrains.java1.dz.dz1;

public class HomeWork1 {

    public static void main(String[] args) {

        // Task 1
        System.out.println("1. Первое задание не выполняется в этом проекте");

        // Task 2
        byte byteVar = 32;
        short shortVar = 1024;
        int intVar = 65536;
        long longVar = 123456789L;
        float floatVar = 123.5f;
        double doubleVar = 12.34567;
        boolean isError = false;
        char charVar = 'w';

        System.out.println("2. Переменные созданы и инициализированы");

        // Task 3
        System.out.println("3. Результат выражения a * (b + (c / d)): " + calc(10, 2, 35, 4) );

        // Task 4
        System.out.println("4. Сумма двух чисел" + (numberInRange(5, 4) ? " " : " не ") + "лежит в пределах" +
                " от 10 до 20 (включительно)");

        // Task 5
        printIsPositiveOrNegativeNumber(-10);

        // Task 6
        System.out.println("6. Передано" + (isNegativeNumber(-56) ? " отрицательное " : " положительное ")
                + "число");

        // Task 7
        greetingByName("Вася");

        // Task 8 *
        printIsLeapYear(2016);

        System.out.println("\nThe End!");

    }

    // for task 8 *
    private static void printIsLeapYear(int year) {

        if (year % 400 == 0) {
            System.out.println("8*. Год високосный");
        } else if (year % 100 == 0) {
            System.out.println("8*. Год не високосный");
        } else if (year % 4 == 0) {
            System.out.println("8*. Год високосный");
        } else {
            System.out.println("8*. Год не високосный");
        }

    }

    // for task 7
    private static void greetingByName(String name) {

        System.out.println("7. Привет, " + name + "!");

    }

    // for task 6
    private static boolean isNegativeNumber(int x) {

        return x < 0;

    }

    // for task 5
    private static void printIsPositiveOrNegativeNumber(int x) {

        if (x >= 0) {
            System.out.println("5. Передано положительное число");
        } else {
            System.out.println("5. Передано отрицательное число");
        }

    }

    // for task 4
    private static boolean numberInRange(int x1, int x2) {

        int sum = x1 + x2;

        return sum >= 10 && sum <= 20;

    }

    // for task 3
    private static float calc (int a, int b, int c, int d) {

        return a * (b + ( (float)c / (float)d) );

    }

}
