package ru.geekbrains.java1.dz.dz3.OleynikovaTanya;

import java.util.Random;
import java.util.Scanner;

//1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
//  попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
//  указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
//  выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

public class GuessNumber {

    public static Scanner scanner;

    public static void main(String[] args){

       scanner = new Scanner(System.in);
       int answer;
       do {
           boolean win = false;
           Random random = new Random();
           int number = random.nextInt(10);
           System.out.println("Загадано случайное число от 0 до 9. У вас есть 3 попытки отгадать его. И это число...");
           for (int i = 1; i <= 3; i++){
               win = guessNumber(number);
               if (win) break;
           }

           printResult(win);
           System.out.println("Повторить игру еще раз? (1 – повторить, 0 – нет)");
           do {
               answer = scanner.nextInt();
           } while (answer != 0 && answer !=1);

        } while (answer == 1);

    }

    public static boolean guessNumber(int number){

        int answer;
        answer = scanner.nextInt();
        if (number > answer){
            System.out.println("Загаданное число больше указанного");
        } else if (number < answer) {
            System.out.println("Загаданное число меньше указанного");
        } else return true;
        return false;

    }

    public static void printResult(boolean win){

        String result;

        if (win) {
            result = "Вы выиграли!!!=)";
        } else {
            result = "Вы проиграли, не расстраивайтесь.";
        }
        System.out.println(result);
    }

}
