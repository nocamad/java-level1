package ru.geekbrains.java1.dz.dz4.DunaevArtur;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ADunaev on 30.10.2017.
 */
public class HomeWork4 {

    public static final int SIZE = 5;

    // 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
    // количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
    // возможных ситуаций
    public static final int DOTS_TO_WIN = 4; // < SIZE

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    private static char[][] map; // игровое поле
    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
    private static Random rand = new Random(); // генератор случайных чисел

    public static void initMap() { // инициализируем массив map(игровое поле)

        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY; // и заполняем каждую ячейку *
            }
        }

    }

    public static void printMap() { // выводим игровое поле в консоль

        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) { // начинаем печатать поле
            System.out.print((i + 1) + " "); // ставим номер строки 1-3
            for (int j = 0; j < SIZE; j++) { // начинаем печатать строку
                System.out.print(map[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
            }
            System.out.println(); // после распечатки строки, делаем перевод каретки
        }
        System.out.println(); // делаем дополнительный перевод строки
    }

    public static void main(String[] args) {
        initMap(); // инициализируем поле
        printMap(); // печатаем в консоль

        while (true) { // запускаем игровой цикл
            humanTurn(); // ход человека
            printMap(); // печать поля
            if (isCheckWin(DOT_X)) { // проверка победы человека
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break; // если поле заполнилось, завершаем игру
            }

            aiTurn(); // ход компьютера
            printMap(); // печать поля
            if (isCheckWin(DOT_O)) { // проверка победы компьютера
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Game Over");
    }

    public static boolean isCheckWin(char c) { // Проверяем победу
        /*
        // Ищем заполненные горизонтальные линии
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) return true;
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) return true;
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) return true;
        // Ищем заполненные вертикальные линии
        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) return true;
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) return true;
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) return true;
        // Ищем заполненные диагональные линии
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[2][0] == c && map[1][1] == c && map[0][2] == c) return true;
        return false;        // если ни одной линии не нашли, значит игрок еще не победил
        */

        // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
        // например, с использованием циклов.
        // 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
        // количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
        // возможных ситуаций
        for (int i = 0; i < SIZE; i++) {
            int k = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c)
                    k += 1;
                else
                    k = 0;
                if (k == DOTS_TO_WIN) return true;
            }

            k = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == c)
                    k += 1;
                else
                    k = 0;
                if (k == DOTS_TO_WIN) return true;
            }
        }

        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == c)
                k += 1;
            else
                k = 0;
            if (k == DOTS_TO_WIN) return true;
        }

        k = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if (map[j][i] == c)
                k += 1;
            else
                k = 0;
            if (k == DOTS_TO_WIN) return true;
        }

        return false;
    }

    private static void humanTurn() { // ход человека
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;


        } while (!isCellValid(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку
        map[y][x] = DOT_X; // после чего ставим туда Х
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;

        int numBlock = 2; // 1 < numBlock < DOTS_TO_WIN - когда начинать блокировать, при двух Х (при 1 легче)
        // 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
        // блокируем строки и столбцы
        for (int l = DOTS_TO_WIN - 1; l >= DOTS_TO_WIN - numBlock; l--) {

            for (int i = 0; i < SIZE; i++) {
                int k = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_X)
                        k += 1;
                    else
                        k = 0;

                    if (k == l) {
                        if (isCellValid(j + 1, i)) {
                            map[i][j + 1] = DOT_O;
                            return;
                        } else if (isCellValid(j - (DOTS_TO_WIN - numBlock), i)) {
                            map[i][j - l] = DOT_O;
                            return;
                        }
                    }
                }

                k = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == DOT_X)
                        k += 1;
                    else
                        k = 0;
                    if (k == l) {
                        if (isCellValid(i, j + 1)) {
                            map[j + 1][i] = DOT_O;
                            return;
                        } else if (isCellValid(i, j - l)) {
                            map[j - l][i] = DOT_O;
                            return;
                        }
                    }
                }
            }

            // блокируем основные диагонали
            int k = 0;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == DOT_X)
                    k += 1;
                else
                    k = 0;
                if (k == l) {
                    if (isCellValid(i + 1, i + 1)) {
                        map[i + 1][i + 1] = DOT_O;
                        return;
                    } else if (isCellValid(i - l, i - l)) {
                        map[i - l][i - l] = DOT_O;
                        return;
                    }
                }
            }

            k = 0;
            for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
                if (map[j][i] == DOT_X)
                    k += 1;
                else
                    k = 0;
                if (k == l) {
                    if (isCellValid(i + 1, j - 1)) {
                        map[j - 1][i + 1] = DOT_O;
                        return;
                    } else if (isCellValid(i - l, j + l)) {
                        map[j + l][i - l] = DOT_O;
                        return;
                    }
                }
            }
        }

        // если нечего блокировать - ставим произвольно
        do { // компьютер пытается случайно выбрать незанятое поле для хода
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O; // как только ячейка найдена, ставим туда О
    }

    public static boolean isCellValid(int x, int y) { // проверка является ли ячейка свободной
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

}
