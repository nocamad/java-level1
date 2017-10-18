package ru.geekbrains.java1.dz.dz1;


//Прошу прощения, из-за работы не успел на предыдущий вебинар и не успел все красиво оформить

public class Main {
    public static void main(String[] args) {
        int I_a = 1; //задание 2
        byte b_a = 1;
        short s_a = 1;
        long l_a = 1;
        float f_a = 1;
        double d_a = 1;
        char c_a = 'a';
        boolean bl_a = true;

        int a = 10;
        int b = 10;
        int c = -10;
        int d = 10;

        String Name = "Николай";

        int year = 1008;


        System.out.println("Выражения a * (b + (c / d), где a = " + a + " b = " + b + " c = " + c + " d = " + d + ", равно " + Calculate(a, b, c, d)); //задание 3

        System.out.println("Лежит ли сумма чисел " + a + " " + b + "? " + task10and20(a, b)); //задание 4

        isPositiveOrNegative(c); //задание 5

        System.out.println("Положительное или отрицательное число " + d + "? " + isNegative(d)); //задание 6

        greetings(Name); //задание 7

        System.out.println("Високосный год " + year + "? " + isYear(year)); //задание 8


    }

    public static int Calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20(int x1, int x2) {
        if ((x1 + x2 > 10) && (x1 + x2 <= 20)) {
            return true;
        }
        return false;
    }

    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Число " + x + " положительное");
        } else {
            System.out.println("Число " + x + " отрицательное");
        }
    }

    public static boolean isNegative(int x) {
        if (x < 0) {
            return true;
        }
        return false;
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + " !");
    }

    public static boolean isYear(int year) {
        if (year % 400 == 0) {
            if (year % 4 == 0 && year % 100 != 0) {
                return true;
            }
        }
        return false;
    }
}
