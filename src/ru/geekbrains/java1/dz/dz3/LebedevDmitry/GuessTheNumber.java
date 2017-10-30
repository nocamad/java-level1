package ru.geekbrains.java1.dz.dz3.LebedevDmitry;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        int attempts = 3;                       // количество попыток
        Scanner sc = new Scanner(System.in);
        String repeatTheGame;                   // повтор игры
        do{
            int hiddenNum =(int)(Math.random()*10);
            System.out.println("Система загадала число от 0 до 9. Попробуйте отгадать.");
            if(guessTheNumber(hiddenNum,attempts,sc)){
                System.out.println("Позравляем, вы угадали!");
            }else {
                System.out.println("Вы проиграли!. Загаданное число было "+hiddenNum);
            }
            System.out.println("Повторить игру еще раз? 1 - да/0 - нет");
            repeatTheGame = sc.next();
        }while("1".equals(repeatTheGame));
        sc.close();
    }// main
    //метод возвращает true/false, если пользователь угадал/не угадал hiddenNum за указанное
    //число attempts. В консоль выводятся подсказки о количестве оставшихся попыток и больше или
    //меньше введенное число
    private static boolean guessTheNumber(int hiddenNum, int attempts, Scanner sc){
        System.out.println("Введите число. Осталось попыток: "+attempts);
        for(int i=1;i<=attempts;i++){
            int number=0;

            while(true){
                if(sc.hasNextInt()){
                    number=sc.nextInt();
                    break;
                }else{
                    System.out.println("Введите целое число!");
                    String enter = sc.next();
                }
            }//while

            if(number==hiddenNum){
                return true;
            }else{
                System.out.println("Неверное число. Осталось попыток: "+ (attempts-i));
                if(attempts-i!=0){System.out.println("Введенное число " + (number>hiddenNum?"больше":"меньше") + " загаданного");}
            } //if else
        } //for

        return false;

    }//guessTheNumber
}
