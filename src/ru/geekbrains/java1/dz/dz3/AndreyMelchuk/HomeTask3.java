package ru.geekbrains.java1.dz.dz3.AndreyMelchuk;

import java.util.Scanner;

public class HomeTask3 {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //  1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        //  При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        //  После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        do{PlayGame();}while (scan.nextInt()==1);
        System.out.println("До встречи...");

        //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
        // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
        // "pear", "pepper", "pineapple", "pumpkin", "potato"};
        // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        // apple – загаданное
        // apricot - ответ игрока
        // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        // Для сравнения двух слов посимвольно, можно пользоваться:
        // String str = "apple";
        // str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        // Играем до тех пор, пока игрок не отгадает слово
        // Используем только маленькие буквы

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                 "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                 "pear", "pepper", "pineapple", "pumpkin", "potato"};
        PlayArrayGame(words);
    }

    private static void PlayArrayGame(String [] words) {
        /*
            Угадываем слово
        */
        String str = words[(int) (Math.random() * (words.length-1))];
        System.out.println("Угадайте слово...");
        //System.out.println(str);
        boolean notsucceeded = true;
        while (notsucceeded) {
            String str_in = scan.nextLine().toLowerCase();
            if (str_in.contentEquals(str)) {
                System.out.println("Вы угадали.");
                notsucceeded = false;
            } else {
                char[] hidden = new char[15];
                for (int i = 0; i < 15; i++) {
                    hidden[i] = 35;
                    if (str.length() > i && str_in.length() > i)
                        if (str.charAt(i) == str_in.charAt(i))
                            hidden[i] = str_in.charAt(i);
                }
                System.out.println(hidden);
            }
        }

    }


    private static boolean PlayGame(){
        /*
            Метод Playgame дает 3 попытки угадать число.
            Возвращает true если число было угадано.
         */
        int val = (int) (Math.random() * 9);
        boolean succeeded = false;

        System.out.println("\nНовая игра!");
        for (int i = 1; i < 4 ; i++) {
            System.out.println("\n\nУгадайте число от 0 до 9");
            System.out.println("Попытка " + i);
            int cin = scan.nextInt();

            if (val == cin) {
                System.out.println("Вы угадали."); succeeded = true;  break;
            } else if (val > cin) {
                System.out.println("Число больше введенного");
            } else {
                System.out.println("Число меньше введенного");
            }
        }

        if(!succeeded) System.out.println("Попыток больше нет. Было загадано число " + val);

        System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");

        return succeeded;
    }


}
