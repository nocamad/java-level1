package ru.geekbrains.java1.dz.dz3.LebedevDmitry;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner sc = new Scanner(System.in);
        String hiddenWord = rndWord(words);     // случайное слово из массива
        int length = 15;                        // длина выводимой в консоль строки при неверном ответе
        char c ='#';                            // заполняющий промежутки символ

        System.out.println("Система загадала слово. Попробуйте отгадать.");

        while(true){
            String answer = sc.nextLine();
            if (hiddenWord.equals(answer)) {
                System.out.println("Слово " + hiddenWord + " угадано верно. Поздравляем!");
                break;
            } else {
                System.out.println("Было загадано другое слово. Совпавшие буквы:");
                System.out.println(matchedLetters(answer, hiddenWord, length,c));
                System.out.println("Попробуйте еще раз!");
            } //if else
        } //while
        sc.close();
    }// main

    // Метод возвращает случайное слово из переданного массива
    private static String rndWord(String[] arrayOfWords) {
        Random rnd = new Random();
        int rndNumber = rnd.nextInt(arrayOfWords.length);
        return arrayOfWords[rndNumber];
    } //rndWord

    // Метод возвращает строку, сотоящую из совпавших между 2мя словами букв. Промежутки заполняются символами c.
    // Длина выводимой последовательности length символов. Параметр 1 или параметр 2 д.б. длиной меньше length
    private static StringBuilder matchedLetters(String word1, String word2, int length, char c) {
        StringBuilder word = new StringBuilder("");
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 > length && length2 > length) {
            System.out.println("Длина возвращаемой строки меньше сравниваемых параметров!");
        } //if
        int minLength = length1 < length2 ? length1 : length2;
        for (int i = 0; i < length; i++) {
            if (i < minLength) {
                char char1 = word1.charAt(i);
                char char2 = word2.charAt(i);
                word.append(char1 == char2 ? char1 : c);
            } else {
                word.append(c);
            } //if else
        } //for
        return word;
    } //matchedLetters
}
