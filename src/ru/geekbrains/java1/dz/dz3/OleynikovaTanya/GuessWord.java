package ru.geekbrains.java1.dz.dz3.OleynikovaTanya;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//* Создать массив из слов
//   String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
//   "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//   "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
//    слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//    apple – загаданное
//    apricot - ответ игрока
//    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//    Для сравнения двух слов посимвольно, можно пользоваться:
//    String str = "apple";
//    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//    Играем до тех пор, пока игрок не отгадает слово
//    Используем только маленькие буквы
public class GuessWord {

    public static Scanner scanner;

    public static void main(String[] args){

        scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String word = words[random.nextInt(words.length - 1)];
        System.out.println("Загадано слово из списка: ");
        System.out.println(Arrays.toString(words));
        System.out.println("И это слово...");

        boolean win = false;
        do {
            win = guessWord(word);
        } while (!win);

    }

    public static boolean guessWord(String word){

        String answer;
        answer = scanner.nextLine();
        if (word.compareTo(answer) == 0){
            System.out.println("Слово угадано!");
            return true;
        } else {
            String correctCharacters = "";
            int indexEnd = Math.min(answer.length(), word.length());
            for (int i = 0; i < indexEnd; i++){
                String character = answer.substring(i, i + 1);
                if (word.startsWith(character, i)) {
                    correctCharacters += character;
                } else {
                    correctCharacters += '#';
                }
            }
            for (int i = indexEnd; i < 15; i ++) {
                correctCharacters += '#';
            }
            System.out.printf("Cимволы, которые стоят на своих местах: %s", correctCharacters);
            System.out.println();
            System.out.println("Попытайтесь еще раз угадать это слово.");
        }
        return false;
    }

}
