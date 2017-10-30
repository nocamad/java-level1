package ru.geekbrains.java1.dz.dz3.lobysheva;

/*
 * Created by Oxana Lobysheva on 17.10.2017.
 */

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static Scanner scan = new Scanner(System.in);
    public static String gameType;
    public static String playAgain;

    public static String[] words =
            {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
             "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
             "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


    public static void main(String[] args){

        gameType = askPlayer("Давай поиграем. Выбери игру: 1 - Угадай число, 2 - Угадай слово", "1", "2");

        do {
            if (gameType.equals("1")){
                playGameWithNumbers();
            } else {
                playGameWithWords();
            }
            playAgain = askPlayer("Повторить игру еще раз? 1 - да, 2 - нет", "1", "2");
        } while (playAgain.equals("1"));

        System.out.println("Игра завершена");
        scan.close();
    }

    private static void playGameWithNumbers(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        String inputValue;
        int answer;

        System.out.println("*****************************************************");
        System.out.println("Загадано число от 0 до 9. Угадай. У тебя три попытки.");
        System.out.println("*****************************************************");

        for (int i = 1; i < 4; i++) {
            System.out.println("Попытка " + i + ". Твой ответ?");
            try {
                inputValue =  scan.nextLine();
                answer = Integer.parseInt(inputValue);
                if (answer == randomNumber) {
                    System.out.println("Угадал(а)");
                    break;
                } else if (answer < randomNumber) {
                    System.out.println("Не угадал(а). Загаданное число больше.");
                } else {
                    System.out.println("Не угадал(а). Загаданное число меньше.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Указано значение в неверном формате");
            }

        }
        System.out.println("Загаданное число = " + randomNumber);
    }


    private static void playGameWithWords(){
        Random random = new Random();
        int randomNumber = random.nextInt(words.length);
        String randomWord = words[randomNumber];
        String answer;

        System.out.println("****************************************************");
        System.out.println("Загадано слово. Тема - Фрукты, Овощи, Грибы. Угадай.");
        System.out.println("****************************************************");

        do {
            String prompt = "";
            System.out.println("Твой ответ?");
            answer = scan.nextLine();
            String randomWordWithMask;
            String answerWithMask;
            if (answer.equals(randomWord)) {
                System.out.println("Угадал(а)");
                break;
            } else {
                randomWordWithMask = putMaskOnWord(randomWord);
                answerWithMask = putMaskOnWord(answer);
                for (int i = 0; i < randomWordWithMask.length(); i++){
                    if (randomWordWithMask.charAt(i) == answerWithMask.charAt(i)){
                        prompt += randomWordWithMask.charAt(i);
                    } else {
                        prompt += "*";
                    }
                }
                System.out.println("Не угадал(а)." + " Подсказка = " + prompt);
            }
        } while (true);

    }

    private static String putMaskOnWord(String word) {
        String wordWithMask = word;
        for (int i = 14; i >= word.length(); i--){
            wordWithMask += "*";
        }
        return wordWithMask;
    }

    private static String askPlayer(String message, String confirm, String reject) {
        String action = "";
        do {
            System.out.println(message);
            action = scan.nextLine();
        } while (!action.equals(confirm) && !action.equals(reject));
        return action;
    }

}
