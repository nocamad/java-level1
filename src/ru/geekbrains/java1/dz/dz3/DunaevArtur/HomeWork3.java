package ru.geekbrains.java1.dz.dz3.DunaevArtur;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*
          2. * Создать массив из слов

               String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                   "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                   "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

               При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с
               загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
               компьютер показывает буквы которые стоят на своих местах.
               apple – загаданное
               apricot - ответ игрока
               ap############# (15 символов, чтобы пользователь не мог узнать длину слова)

               Для сравнения двух слов посимвольно, можно пользоваться:
                   String str = "apple";
                   str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции

               Играем до тех пор, пока игрок не отгадает слово
               Используем только маленькие буквы
        */

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        int x = rand.nextInt(words.length);
        String randWord = words[x];

        System.out.println("Компьютер загадал одно из слов: " + Arrays.toString(words));
        System.out.println("Угадай какое? (для завершения игры набери end)");

        String word, hintWord;

        do {
            word = sc.nextLine().toLowerCase();
            System.out.println(word);

            hintWord = compareWords(word, randWord);

            if ( word.equals(hintWord) ) {
                System.out.println("Угадал!");
            } else {
                System.out.println("Не угадал! Подсказка: " + hintWord);
            }

        } while ( !word.equals("end") && !word.equals(randWord) && !word.equals(hintWord));

        System.out.println("Компьютер загадал слово " + randWord);

    }

    private static String compareWords(String word, String randWord) {

        int length = word.length() <= randWord.length() ? word.length() : randWord.length();
        String subStr = "", result = "###############";

        if ( !(word.equals(randWord)) ) {

            int i;
            for (i = 0; i < length; i++) {

                if (word.charAt(i) == randWord.charAt(i)) {
                    subStr = subStr + word.charAt(i);
                } else {
                    subStr = subStr + "#";
                }

            }

            result = subStr + result.substring(i);

        } else {

            result = word;

        }

        return result;

    }

}
