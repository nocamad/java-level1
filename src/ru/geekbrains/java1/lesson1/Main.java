package ru.geekbrains.java1.lesson1;

import java.util.Random;

/**
 * Created by i on 12.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("привет мир!!!");

        byte b = 125;

        System.out.println("b= " + b);
        int i = 2147483647;
        System.out.println("i= " + i);
        long lo = 21474836474786856L;
        System.out.println("lo= " + lo);

        boolean bool = true; // false
        System.out.println(bool);


        String s = "строка";
        System.out.println(s);


        int a, v;
        a = 10;
        v = 20;
        b = 50;

        a = a + v;
        a += v;

        int d = a + v;

        a = 100;
        b = 50;
        if (a < b) {
            System.out.println("больше");
            System.out.println("+++");
        } else {
            System.out.println("меньше");
        }




    }
}
