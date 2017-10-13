package ru.geekbrains.java1.lesson1;

/**
 * Created by i on 12.10.2017.
 */
public class Primer {
    public static void main(String[] args) {
        int u = 10, g = 20;
        int i = 107, o = 204;

        int sum1 = add(u, g);
        System.out.println(sum1);
        int sum2 = add(i, o);
        System.out.println(sum2);
        int sum3 = add(3, 5);
        System.out.println(sum3);
    }


    public static int add(int a, int b) {
        int d = a + b;
        return d;
    }



}
