package ru.geekbrains.java1.dz.dz1.ruslan_gafurov;

public class HomeWork {
    public static void main(String args[]) {
        //Вызов метода инициализация переменных всех типов
        initialization();

        //Вывод в консоль возвращенного значения метода для решения примера A*(B+(C/D))
        System.out.println("A*(B+(C/D)) = " + calc(6, 9, 8, 4));

        /*Вывод в консоль возвращенного значения метода, принимаюего на вход два числа, и проверяющий что их сумма
        лежит в пределах от 10 до 20(включительно)*/
        System.out.println("Лежит ли сумма между 10 и 20 включительно: " + task4(7, 3));

        //Вызов метода, определяющего является число Положительным или Отрицательным
        posOrNeg(5);

        //Вывод в консоль возвращенного значения метода, определяюшего является ли число отрицательным
        System.out.println("Отрицательно ли число: " + negative(-8));

        /*Вызов метода, которому в качестве параметра передается строка, обозначающая имя,
        метод выводит в консоль сообщение «Привет, указанное_имя!» */
        helloGuy("Руслан");

        //Вызов метода, который определяет високосный или нет переданный ему год.
        leapYear(2017);
    }

    public static void initialization() {
        int i = 5650778;
        long l = 459632055L;
        short s = 456;
        byte bt = 34;
        float f = 56.78f;
        double dl = 56098.486;
        char cr = 'F';
        boolean bool = true;
    }

    public static int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean task4(int x1, int x2) {
        return (((x1 + x2) >= 10) && ((x1 + x2) <= 20));
    }

    public static void posOrNeg(int p) {
        if (p >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean negative(int n) {
        return (n < 0);
    }

    public static void helloGuy(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Год является високосным");
        } else {
            System.out.println("Год не является високосным");
        }
    }
}
