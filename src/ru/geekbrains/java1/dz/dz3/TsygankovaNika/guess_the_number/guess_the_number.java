package ru.geekbrains.java1.dz.dz3.TsygankovaNika.guess_the_number;

import java.util.Random;
import java.util.Scanner;

public class guess_the_number {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Угадайте число от 0 до 9. У вас 3 попытки.");
        while (true){
            play();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int PlayAgain = scanner.nextInt();
            if (PlayAgain == 0){
                System.out.println("Игра окончена.");
                break;
            }
        }
    }
    private static void play(){
            Random random = new Random();
            int a = random.nextInt(9);
            for (int j = 1; j <= 3; j++) {
                System.out.println("Попытка " + j);
                int input_number = scanner.nextInt();
                if (input_number == a) {
                    System.out.println("Вы угадали.");
                    return;
                } else if (input_number > a) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            }
            System.out.println("Вы не угадали. Это было число " + a);
    }
}