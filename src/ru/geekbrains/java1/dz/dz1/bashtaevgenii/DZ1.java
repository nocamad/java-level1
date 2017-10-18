package ru.geekbrain.java1.dz.bashtaevgenii;

public class DZ1 {
    public static void main(String[] args) {
        /*byte b = 1;
        short sh = 1;
        int i = 1;*/
        long l = 6584L;
        /*float f = 1f;
        double d = 1;*/
        double v1 = 36, v2 = 45, v3 = 4566, v4 = 123;
        //boolean bool = true;
        //char ch = 'A';

        System.out.println("Задание №3 Результат вычисления уравнения a*(b+c/d)=" + vichislenie(v1, v2, v3, v4));
        System.out.println("Задание №4 Результат сложения a и b лежит между 10 и 20 включительно? ответ - " + sravnenie1020(10, 3));
        pishemZnakChisla(-95421L);
        System.out.println("задание №6 число " + l + " отрицательное? ответ - " + proverkaOtricanie(l));
        pishemImya("Evgenii");
        visokosniyGod(2017);
    }

    static double vichislenie(double a, double b, double c, double d) {
        a *= (b + c / d);
        return a;
    }


    static boolean sravnenie1020(int a, int b) {
        int srav;
        srav = a + b;
        if (10 <= srav && srav <= 20) {
            return true;
        } else {
            return false;
        }
    }


    static void pishemZnakChisla(long a) {
        if (a < 0) {
            System.out.println("Задание №5 Число " + a + " отрицательное.");
        } else {
            System.out.println("Задание №5 Число " + a + " положительное.");
        }
    }


    static boolean proverkaOtricanie(long a) {
        return (a < 0);
    }


    static void pishemImya(String imya) {
        System.out.println("Привет, " + imya + "!");
    }

    static void visokosniyGod(int a) {
        if (a % 400 == 0) {
            visokos(a);
        } else {
            if (a % 100 == 0) {
                nevisokos(a);
            } else {
                if (a % 4 == 0) {
                    visokos(a);
                } else {
                    nevisokos(a);
                }
            }
        }
    }

    static void visokos(int x) {
        System.out.println("Год " + x + " является високосным.");
    }

    static void nevisokos(int x) {
        System.out.println("Год " + x + " не является високосным.");
    }
}
