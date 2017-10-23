package ru.geekbrains.java1.lesson3;

import java.util.Scanner;

/**
 * Created by i on 19.10.2017.
 */
public class Primer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = 0;
        do {
            System.out.println("введите целое число <20 &  >1:");
//            if (scanner.hasNextInt()) {
                b = scanner.nextInt();
//            }
        } while (!(b < 20 && b > 1));
        System.out.println("введеное число: " + b);


//        scanner.nextLine();
//        scanner.next();


    }
}
