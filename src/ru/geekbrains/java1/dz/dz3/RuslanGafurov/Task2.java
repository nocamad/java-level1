package ru.geekbrains.java1.dz.dz3.RuslanGafurov;

import java.util.Random;
import java.util.Scanner;


// Игра Угадай Слово. Количество попыток не ограничено. Можно вводить что угодно, но пройдет тольно 1 слово
//без пробелов из строчных латинских букв. После победы игру можно повторить.
//
//Введите cheater для подсказки слова.

public class Task2 {
    public static void main(String[] args) {
        boolean win=false;
        char[] secretword = new char[15];
        String myword, userword;
        do{
            createSWord(secretword);
            myword = randomWord();
            mainBoard();
            do{
//              System.out.println(myword);
                System.out.println("Угадайте слово (введи pass чтобы сдаться):");
                printSWord(secretword);
                userword = userInput();
                if(userword.equals("pass")) {
                    System.out.println("Вы сдались. Правильное слово: "+ myword);
                    break;
                }
                if(userword.equals("cheater")) {
                    System.out.println("Вам откроится 1 буква.");
                    openWord(secretword,myword);
                    continue;
                }
                win=checkWord(myword,userword,secretword);
                if(win) {
                    System.out.println("Это правельный ответ!");
                }
            } while (!win);
        } while(repeatGame());
    }

    //Заполнение массива # для 1го запуска
    private static void createSWord(char[] secretword){
        for(int i=0;i<secretword.length;i++){
            secretword[i]='#';
        }
    }

    //Получения слова пользователя, только 1 слово, строчные латинские.
    private static String userInput() {
        Scanner scanner = new Scanner(System.in);
        int symbol;
        boolean nocorect;
        String input;
        do {
            nocorect = false;
            System.out.print("Введите Ваше слово:");
            input = scanner.nextLine();
            for (int i = 0; i < input.length(); i++) {
                symbol = (int)input.charAt(i);
                if (symbol < 97 || symbol > 122) {
                    nocorect = true;
                    System.out.println("Вводите только 1 слово строчными латинскими буквами.");
                    break;
                }
            }
        } while (nocorect);
        return input;
    }

    //Вывод правил игры
    private static void mainBoard(){
        System.out.println(
                        "\n------------------------------------------------------------------------------\n" +
                        "|                         Игра \"Угадай Cлово\"                                |\n" +
                        "|                                                                            |\n" +
                        "|  Правила: Загадано 1 слово. У Вас есть сколько угодно попыток его угадать. |\n" +
                        "|       Ваше вариант должен состоять только из строчных латинских букв.      |\n" +
                        "|                                     Удачи!!                                |\n" +
                        "|                                                                            |\n" +
                        "------------------------------------------------------------------------------\n");
    }

    //Проверка слова
    private static boolean checkWord(String myword, String userword, char[] secretword){
        if (myword.equals(userword)){
            return true;
        }
        int minLength = Math.min(myword.length(),userword.length());
        for(int i=0;i<minLength;i++){
            if(myword.charAt(i)==userword.charAt(i)){
                secretword[i]=myword.charAt(i);
            }
        }
        return false;
    }

    //Выбор случайнного слова из массива
    private static String randomWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    //Запрос на повтор игры
    private static boolean repeatGame() {
        int input = -1;
        String trash;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Повторить игру еще раз? 1-Да/0-Нет: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                trash = scanner.next();
            }
            if (input == 1 || input == 0) {
                exit = true;
            } else {
                System.out.println("Упс... Я Вас не понял.");
            }
        } while (!exit);
        return (input == 1);
    }

    //Метод печати массива символов в одну строчку.
    private static void printSWord(char[] word){
        for(char a:word){
            System.out.print(a);
        }
        System.out.print("\n\n");
    }

    //Метод - читер. Открывает 1 закрытую букву с начала.
    private static void openWord(char[] sword, String myword){
        for(int i=0;i<myword.length();i++){
            if(sword[i]=='#'){
                sword[i]=myword.charAt(i);
                break;
            }
        }
    }
}


