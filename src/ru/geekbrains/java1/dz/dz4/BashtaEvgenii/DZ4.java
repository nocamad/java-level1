package ru.geekbrains.java1.dz.dz4.BashtaEvgenii;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DZ4 {
    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
    private static Random rand = new Random(); // генератор случайных чисел
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static char[][] initMap(int x) { // инициализируем массив map(игровое поле)
        char[][] map=new char [x][x]; // игровое поле
        for (int i = 0; i < x; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < x; j++) {
                map[i][j] = '*'; // и заполняем каждую ячейку *
            }
        }
        return map;
    }

    public static void printMap(char map[][]) { // выводим игровое поле в консоль
        for (int i =0; i<=map.length;i++) {
            System.out.print(" "+i+" |"); // первая строка с координатами
        }
        System.out.println();
        for (int i = 0; i <= map.length; i++) { // начинаем печатать строку
            System.out.print("---|"); //Разделитель поля
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) { // начинаем печатать поле
            System.out.print(" "+(i + 1) + " |"); // ставим номер строки 1-3
            for (int j = 0; j < map[i].length; j++) { // начинаем печатать строку
                System.out.print(" "+map[i][j] + " |"); // посимвольно печатаем содержимое каждой ячейки поля
            }
            System.out.println();
            for (int j = 0; j <= map[i].length; j++) { // начинаем печатать строку
                System.out.print("---|"); //Разделитель поля
            }
            System.out.println(); // после распечатки строки, делаем перевод каретки
        }
        System.out.println(); // делаем дополнительный перевод строки
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

    public static void main(String[] args) {
        int razmerPolya=getNumberFromScanner("Введите размер игрового поля Х:Х",3,Integer.MAX_VALUE-1);
        int dlinnaWin=getNumberFromScanner("Введите количество ячеек в ряд для выигрыша:",3,razmerPolya);
        char[][] map=initMap(razmerPolya); // инициализируем поле
        printMap(map); // печатаем в консоль

        while (true) { // запускаем игровой цикл
            humanTurn(map); // ход человека
            printMap(map); // печать поля

            if (isCheckWin('X',map,dlinnaWin)) { // проверка победы человека
                System.out.println(ANSI_GREEN+"Вы выиграли!"+ANSI_RESET);
                break;
            }
            if (isMapFull(map)) break; // если поле заполнилось, завершаем игру
            aiTurn(map); // ход компьютера
            printMap(map); // печать поля
            if (isCheckWin('O',map,dlinnaWin)) { // проверка победы компьютера
                System.out.println(ANSI_RED+"Победил компьютер"+ANSI_RESET);
                break;
            }
            if (isMapFull(map)) break;
        }
        System.out.println("Game Over");
    }


    public static boolean isCheckWin(char c, char map[][],int x) { // Проверяем победу
// Ищем заполненные горизонтальные линии

        for (int i=0; i<map.length;i++) {
            for (int j=0; j<=map.length-x;j++){
                for (int k = j; k < j+x; k++) {
                    if (map[i][k] != c) break;
                    if (k==j+x-1) return true;
                }
            }
        }
//Ищем заполненые вертикальные линии
        for (int i=0; i<map.length;i++) {
            for (int j=0; j<=map.length-x;j++){
                for (int k = j; k < j+x; k++) {
                    if (map[k][i] != c) break;
                    if (k==j+x-1) return true;
                }
            }
        }
//Ищем заполненые горизонтали. Работает для любого поля и любой диагоналии любой длинны выигрыхной цепочки.

        String yyy=Arrays.deepToString(map);
        String xxx="";
        for (int z=0; z<yyy.length();z++) {
            if (yyy.charAt(z)=='X'||yyy.charAt(z)=='O'||yyy.charAt(z)=='*') xxx+=yyy.charAt(z);
        }
        for (int q=0;q<xxx.length()-x*map.length;q++ ) {
            for (int w=q; w<=q+x*map.length;w+=map.length+1) {
                if (xxx.charAt(w) != c) break;
                if (w==q+(x-1)*(map.length+1)) return true;
            }
        }
        char[][] povorot = new char[map.length][map.length];
        for (int a=0;a<map.length;a++) {
            for (int b=0;b<map.length;b++) {
                povorot [b][a]=map[a][b];
            }
        }
        String yyy2=Arrays.deepToString(povorot);
        String xxx2="";
        for (int z=0; z<yyy2.length();z++) {
            if (yyy2.charAt(z)=='X'||yyy2.charAt(z)=='O'||yyy2.charAt(z)=='*') xxx2+=yyy2.charAt(z);
        }
        for (int q=0;q<xxx2.length()-x*map.length;q++ ) {
            for (int w=q; w<=q+x*map.length;w+=map.length-1) {
                if (xxx2.charAt(w) != c) break;
                if (w==q+(x-1)*(map.length-1)) return true;
            }
        }
        return false;        // если ни одной линии не нашли, значит игрок еще не победил
    }

    private static void humanTurn(char map[][]) { // ход человека
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х(горизонталь) и У(вертикаль)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y, map)); // пользователь
        // вводит координаты до тех пор, пока они не будут корректны и не укажет на свободную ячейку
        map[y][x] = 'X'; // после чего ставим туда Х
    }

    private static boolean isMapFull(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '*') return false; // если на поле нашли хотя бы одну *,
                // значит поле еще не заполнилось
            }
        }
        return true;
    }

    private static void aiTurn(char map[][]) {
        int x, y;
        do { // компьютер пытается случайно выбрать незанятое поле для хода
            x = rand.nextInt(map.length);
            y = rand.nextInt(map.length);
        } while (!isCellEmpty(x, y,map));
        map[y][x] = 'O'; // как только ячейка найдена, ставим туда О
    }

    public static boolean isCellEmpty(int x, int y,char map[][]) { // проверка является ли ячейка свободной
        if (x < 0 || x > map.length-1 || y < 0 || y > map.length-1||map[y][x] != '*') return false; // если
        // указаны неверные координаты, считаем что ячейка условно занята и если в ячейке не *
        return true; // ячейка свободна
    }

}
