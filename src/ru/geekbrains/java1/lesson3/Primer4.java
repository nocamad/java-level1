package ru.geekbrains.java1.lesson3;

/**
 * Created by i on 19.10.2017.
 */
public class Primer4 {
    public static void main(String[] args) {
        print("ewtqwetg", "tewrgtqergte", "sdgsdsdf");
        print("4");
        print("1","12","13","14","15","16","17","18");
    }

    private static void print(String... s) {
        for (String item : s) {
            System.out.println(item);
        }
    }
}
