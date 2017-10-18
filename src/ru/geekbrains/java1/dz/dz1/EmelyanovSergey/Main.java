package ru.geekbrains.java1.dz.dz1.EmelyanovSergey;

public class Main {
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.2 ======================");
        boolean vBool = true;
        byte vByte = 120;
        short vShort = 32000;
        int vInt = 1;
        long vLong = -100;
        float vFloat = 1.1f;
        double vDouble = 10.22333;
        char vChar = 'F';

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.3 ======================");
        System.out.println(eval1(1, 2, 3, 4));
        System.out.println(eval1(1.1, 21, 10, 11.22222));

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.4 ======================");
        double p1 = 11, p2 = 6;
        if (isSummInRange(p1, p2)) {
            System.out.println(p1 + "+" + p2 + " в пределе >=10 <=20");
        } else {
            System.out.println(p1 + "+" + p2 + " вне пределa");
        }
        p1 = 17;
        p2 = 60;
        if (isSummInRange(p1, p2)) {
            System.out.println(p1 + "+" + p2 + " в пределе >=10 <=20");
        } else {
            System.out.println(p1 + "+" + p2 + " вне пределa");
        }

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.5 ======================");
        printNumberPosNeg(-10);
        printNumberPosNeg(100);

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.6 ======================");
        System.out.println("10 отрицательное = " + isNumberNegative(10));
        System.out.println("-5 отрицательное = " + isNumberNegative(-5));

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.7 ======================");
        prnName("Вася");

        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////

        System.out.println("п.8 ======================");
        for (int i = 0; i <= 2017; i++)
            isLeapYear(i);


    }

    private static double eval1(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean isSummInRange(double param1, double param2) {
        return (((param1 + param2) >= 10) && ((param1 + param2) <= 20));
    }

    private static void printNumberPosNeg(int number) {
        if (number >= 0) {
            System.out.println("число " + number + " положительное");
        } else {
            System.out.println("число " + number + " отрицательное");
        }
    }

    private static boolean isNumberNegative(int number) {
        return (number < 0);
    }

    private static void prnName(String inName) {
        System.out.println("Привет, " + inName + "!");
    }

    private static void isLeapYear(int inYear) {
        boolean isLeap = false;

        int ostMod4 = inYear % 4;
        int ostMod100 = inYear % 100;
        int ostMod400 = inYear % 400;
        if (inYear >= 4) isLeap = (ostMod4 == 0);
        if ((inYear >= 100) && isLeap && (ostMod100 == 0)) isLeap = false;
        if ((inYear >= 400) && (ostMod400 == 0)) isLeap = true;

        if (isLeap) {
            System.out.println("Год " + inYear + " високосный");
        } else {
            System.out.println("Год " + inYear + " -- ");
        }
    }
}
