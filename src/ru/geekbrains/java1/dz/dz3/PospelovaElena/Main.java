package ru.geekbrains.java1.dz.dz3.PospelovaElena;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Game 1. Guess the number in three tries.");
        while (plaing()) {
            gameCycle();
        }

        System.out.println();
        System.out.println("Game 2. Guess word.");
        fruits();


    }

    private static boolean plaing() {
        System.out.println("Playing? 1-yes, 0-no.");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        return answer == 1;
    }

    private static void gameCycle() {
        int targetNum = randomNumber();
        System.out.println("Number?");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            boolean win = false;

            for (int i = 0; i < 2; i++) {

                if (num == targetNum) {
                    System.out.println("You win!");
                    win = true;
                    break;
                } else if (num > targetNum) {
                    System.out.println("Your number is greater");
                } else {
                    System.out.println("Your number is less");
                }

                System.out.println("Number?");
                num = sc.nextInt();
            }

            if (!win) System.out.println("You lose(");
            System.out.println();
        } else {
            System.out.println("Enter a number!");
        }
    }


    private static int randomNumber() {
        Random random = new Random();
        int a = random.nextInt(10);
        return a;
    }

    private static void fruits() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random randm = new Random();
        String targetWord = words[randm.nextInt(words.length)];
        Scanner scan = new Scanner(System.in);
        String enterWord = "";
       // System.out.println(targetWord);
        String[] result = {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#",};
        int length = 0;

        while (true) {
            enterWord = scan.next();

            if (targetWord.equals(enterWord)) {
                System.out.println("you guessed!");
                break;
            }

            if (enterWord.length() > targetWord.length()) {
                length = targetWord.length();
            } else {
                length = enterWord.length();
            }

            for (int i = 0; i < length; i++) {
                if (enterWord.charAt(i) == targetWord.charAt(i)) {
                    result[i] = String.valueOf(enterWord.charAt(i));
                }
            }

            for (String a : result) {
                System.out.print(a);
            }

            System.out.println();
        }
    }
}
