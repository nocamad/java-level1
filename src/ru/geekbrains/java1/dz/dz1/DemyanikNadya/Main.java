package ru.geekbrains.java1.dz.dz1.DemyanikNadya;

public class Main {

    public static void main(String[] args) {
        //	1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
        System.out.println("Задача №1 выполнена - проект создан");

        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        // примитивные
        byte bb = 125;
        int a = 2, b = 4, c = 6, d = -8;
        long lo = 1000L;
        boolean bool = true;
        // ссылочные
        String s = "Иван";

        System.out.println("Задача №2 выполнена - переменные созданы и проинициализированы:");
        System.out.println("  byte bb= " + bb);
        System.out.println("  int a= " + a + ", b= " + b + ", c= " + c + ", d= " + d);
        System.out.println("  long l= " + lo);
        System.out.println("  boolean bool= " + bool);

        //3.
        System.out.println("Задача №3 выполнена: результат выражения a * (b + (c / d)) равен " + task3(a, b, c, d));

        //4.
        System.out.println("Задача №4 выполнена: cумма чисел " + a + " и " + b + " в пределах 10 и 20? - " + task4(a, b));

        //5.
        System.out.print("Задача №5 выполнена: ");
        task5(c);

        //6.
        System.out.println("Задача №6 выполнена: " + d + " отрицательное число? - " + task6(d));

        //7.
        System.out.print("Задача №7 выполнена: ");
        task7(s);

        //8. *
        System.out.print("Задача №8 выполнена: ");
        leapYear(2016);
        leapYear(2017);
        System.out.println(task3(1, 2, 3, 10));
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    private static int task3(int a, int b, int c, int d) {
        int result = 0;
        if (d != 0) {
            result = a * (b + (c / d));
        }
        return result;
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false
    private static boolean task4(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    private static void task5(int a) {
        System.out.println("передано " + ((a >= 0) ? "положительное" : "отрицательное") + " число " + a);
//        String result =  "положительное";
//        if (a < 0) result = "отрицательное";
//        System.out.println("передано " + result + " число " + a);
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
    // если число отрицательное;
    private static boolean task6(int a) {
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void task7(String s) {
        System.out.println("Привет, " + s + "!");
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void leapYear(int year) {
        boolean isLeap;
        isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        String noLeap = "";
        if (!isLeap) {
            noLeap = " не";
        }

        System.out.println(year + " год" + noLeap + " является високосным");
    }
}
