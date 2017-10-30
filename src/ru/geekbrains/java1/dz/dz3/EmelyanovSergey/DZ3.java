package ru.geekbrains.java1.dz.dz3.EmelyanovSergey;



import java.util.Random;
import java.util.Scanner;

public class DZ3 {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.print("Выберите вариант [1=первое задание] [2=второе задание]");
        switch (scan.next()) {
            case "1" : game1(3);
            break;
            case "2" : game2();
            break;
            default :
                System.out.println("Неверно указан вариант");
        }

    }


//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////

    private static void game1(int inTryNumber) {

        Scanner scanner = new Scanner(System.in);
        int winCounter = 0;
        int loseCounter = 0;

        for (; ; ) {

            Random random = new Random();
            int guessNumber = random.nextInt(10); // генерирует от 0 до 9 включительно
            boolean Success = false;

            System.out.println("================================================ new game1 started");
            System.out.println("Угадайте число от 0 до 9 за " + inTryNumber + " попытки");
            for (int tryCounter = 1; tryCounter <= inTryNumber; tryCounter++) {
                System.out.print("Попытка " + tryCounter + ". Ваш ответ: ");
                int answerNumber = -1;
                if (scanner.hasNextInt()) {
                    answerNumber = scanner.nextInt();
                } else {
                    scanner.next();
                }
                if ((answerNumber < 0) || (answerNumber > 9)) {
                    System.out.println("Введеное число некорректно. Введите число от 0 до 9");
                    tryCounter--;
                }
                if (answerNumber == guessNumber) {
                    System.out.println("Вы угадали число " + answerNumber + " с " + tryCounter + " попытки");
                    Success = true;
                    break;
                }
                if (answerNumber > guessNumber) {
                    System.out.println("МЕНЬШЕ - загаданное число меньше чем " + answerNumber);
                }
                if (answerNumber < guessNumber) {
                    System.out.println("БОЛЬШЕ - загаданное число больше чем " + answerNumber);
                }
            }

            if (Success) {
                winCounter++;
            } else {
                System.out.println("Вы не угадали. Загаданное число " + guessNumber);
                loseCounter++;
            }

            System.out.print("[Выигрышей-" + winCounter + " Проигрышей-" + loseCounter + "] Повторить игру еще раз? 1-да / 0-нет : ");
            int answer = 0;
            try {
                answer = Integer.parseInt(scanner.next());
            } finally {
                if (answer == 0) return;
            }
        }
    }

    //////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    private static void game2() {

        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int tryCount =0;

        int arrIndexRnd = random.nextInt(words.length); //выдает случайное число от 0 до words.length-1 включительно
        String guessWord = words[arrIndexRnd]; //загаданное слово

        String userMatchWord = new String(); //ШАБЛОН - отгаданное слово по буквам ######## в начале, #=неугаданная буква
        for (int i=0;i<guessWord.length();i++){
            userMatchWord+='#'; //в массиве слов words нет символа '#'. #=неотгаданный пока символ
        };

        System.out.println("================================================ new game2 started");
        while (true) {
            tryCount++;

            System.out.print("Попытка "+tryCount+". Введите слово:");
            String answerWord = scanner.next();
            System.out.println();

            if (answerWord.equals(guessWord)) {
                System.out.println("Вы угадали - загаданное слово = "+guessWord);
                break;
            }

            //найдем соответствия и поменям строку угаданных символов userMatchWord
            int countMatchChar = 0;
            for (int i=0;i<guessWord.length();i++){ //цикл по буквам загаданного слова
                for (int j=0;j<answerWord.length();j++) { //цикл по буквам слова-ответа
                    if ((guessWord.charAt(i) == answerWord.charAt(j)) /*буква совпала*/
                            &&
                         (userMatchWord.charAt(i) == '#')) /*буква еще не угадана = в шаблоне на ее месте '#' */{
                        countMatchChar++;
                        //поменять символ в строке по его индексу -
                        char[] tempStrArr = userMatchWord.toCharArray();
                        tempStrArr[i] = guessWord.charAt(i);
                        userMatchWord = new String(tempStrArr);
                    }
                }
            }

            if (userMatchWord.equals(guessWord)) { //в Шаблоне не осталось символов '#' нет смысла разгадыать дальше
                System.out.println("Вы угадали слово по символам - загаданное слово = "+guessWord);
                break;
            }

            System.out.print("Вы открыли "+countMatchChar+" букв. Подсказка = "+userMatchWord);
            for (int i=userMatchWord.length();i<15;i++) System.out.print("#");
            System.out.println();

        }

        System.out.println("Количество попыток = "+tryCount);

    }

}
