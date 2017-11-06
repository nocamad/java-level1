package ru.geekbrains.java1.dz.dz4.OleynikovaTanya;

import java.util.Random;
import java.util.Scanner;

public class TickTackToe {

    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
    private static Random rand = new Random(); // генератор случайных чисел
    private static final int SIZE = fieldSize(); // размер поля
    private static final int DOTS_TO_WIN = (SIZE > 3) ? SIZE - 1: SIZE; // количество фишек для победы
    private static char[][] map = new char[SIZE][SIZE]; // игровое поле
    private static int currentX, currentY;
    private static final int checkLength = DOTS_TO_WIN == SIZE ? DOTS_TO_WIN - 1 : DOTS_TO_WIN;


    public static int fieldSize() {
        System.out.println("Введите число для задания размера поля игры в крестики-нолики (по умолчанию поле размерностью 3x3):");
        try {
            int fieldSize = sc.nextInt();
            return fieldSize < 3 ? 3 : fieldSize;
        } catch (Exception e) {
            return 3;
        }
    }

    public static void initMap() { // определяем размер поля
        for (int i = 0; i < SIZE; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '*'; // и заполняем каждую ячейку *
            }
        }
    }

    public static void printMap() { // выводим игровое поле в консоль

        for (int i = -1; i < SIZE; i++) { // начинаем печатать поле
            System.out.print((i + 1) + " "); // ставим номер строки 1-SIZE
            for (int j = 0; j < SIZE; j++) { // начинаем печатать строку
                if (i == -1) {
                    System.out.print((j + 1)); // первая строка с координатами
                } else {
                    System.out.print(map[i][j]); // посимвольно печатаем содержимое каждой ячейки поля
                }

                if(j != SIZE - 1) { System.out.print(" ");} // для последнего столбца пробел не печатается
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
            if (isCheckWin('X')) { // проверка победы человека
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) break; // если поле заполнилось, завершаем игру
            aiTurn(); // ход компьютера
            printMap(); // печать поля
            if (isCheckWin('O')) { // проверка победы компьютера
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) break;
        }
        System.out.println("Game Over");
    }


    public static boolean isCheckWin(char c) { // Проверяем победу
        int lineLength;

        // Ищем заполненные горизонтальные линии
        if (testHorizontalVerticalLines(c, true)  // горизонтальные линии
                || testHorizontalVerticalLines(c, false) // вертикальные линии
                || testMainDiagonal(c, true) // главная диагональ
                || testMainDiagonal(c, false) // побочная диагональ
                || testLeftRightMainDiagonal(c, true) // диагональ слева от главной
                || testLeftRightMainDiagonal(c, false)) // диагональ справа от главной
            return true;

        return false;   // если ни одной линии не нашли, значит игрок еще не победил
    }

    // Проверяются горизонтальные или вертикальные линии в зависимости от параметра horizontal
    public static boolean testHorizontalVerticalLines(char c, boolean horizontal) {

        int lineLength = 0;
        for (int i = 0; i < SIZE; i++){
            if ((horizontal && map[currentX][i] == c) || (!horizontal && map[i][currentY] == c)) {
                lineLength++;
            } else lineLength = 0;

            if (lineLength == DOTS_TO_WIN) return true;

        }

        return false;
    }

    // Проверятся главная или побочная диагональ в зависимости от параметра main
    public static boolean testMainDiagonal(char c, boolean main) {

        if ((main && currentX != currentY) ||
            (!main && currentY != checkLength - currentX )) return false;

        int lineLength = 0;

        for (int i = 0; i < SIZE; i++) {
            if ((main && map[i][i] == c) ||
                    (!main && map[i][checkLength - i] == c)) {
                lineLength++;
            } else lineLength = 0;

            if (lineLength == DOTS_TO_WIN) return true;
        }

        return false;
    }

    // Проверяются диагонали, расположенные слева или справа от главной в зависимости от параметра left
    public static boolean testLeftRightMainDiagonal(char c, boolean left) {

        if ((left && currentX <= currentY) ||
                (!left && currentX >= currentY)) return false;

        int lineLength = 0;
        int difference = left ? currentX - currentY : currentY - currentX;
        for (int x = left ? currentX - currentY : 0; left ? x < SIZE : x + difference < SIZE; x++) {

            if ((left && map[x][x-difference] == c) ||
                    (!left && map[x][x+difference] == c)) {
                lineLength++;
            } else lineLength = 0;

            if (lineLength == DOTS_TO_WIN) return true;

        }

        return false;
    }

    private static void humanTurn() { // ход человека
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;


        } while (!isCellEmpty(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку

        currentX = y;
        currentY = x;
        map[y][x] = 'X'; // после чего ставим туда Х
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '*') return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;

        if (findBestMoveHorizontalVertical(true) ||
                findBestMoveHorizontalVertical(false) ||
                findBestMoveMainDiagonal(true) ||
                findBestMoveMainDiagonal(false) ||
                findBestMoveLeftRightMainDiagonal(true) ||
                findBestMoveLeftRightMainDiagonal(false)) {
            return;
        }

        do { // компьютер пытается случайно выбрать незанятое поле для хода
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellEmpty(x, y));

        currentX = y;
        currentY = x;

        map[y][x] = 'O'; // как только ячейка найдена, ставим туда О
    }

    // Ищется лучший ход по горизонтали или вертикали в зависимости от параметра horizontal
    public static boolean findBestMoveHorizontalVertical(boolean horizontal) {

        int lineLength = 0;
        int previous = -1;
        for (int i = 0; i < SIZE; i++){

            if ((horizontal && map[currentX][i] == 'X') ||
                    (!horizontal && map[i][currentY] == 'X')){
                lineLength++;
            } else if (previous == -1) {
                previous = i;
            } else if (lineLength != DOTS_TO_WIN - 1) return false;

        }

        if (lineLength == DOTS_TO_WIN - 1) {
            if (horizontal && isCellEmpty(previous, currentX)) {
                map[currentX][previous] = 'O';
                currentY = previous;
            } else if (!horizontal && isCellEmpty(currentY, previous)) {
                map[previous][currentY] = 'O';
                currentX = previous;
            }
            return true;
        }
        return false;
    }

    // Ищется лучший ход по главной или побочной диагонали в зависимости от параметра main
    public static boolean findBestMoveMainDiagonal(boolean main) {

         if ((main && currentX != currentY) ||
                (!main && currentY != checkLength - currentX )) return false;

        int lineLength = 0;
        int previousX = -1;
        int previousY = -1;
        for (int i = 0; i < SIZE; i++) {

            if ((main && map[i][i] == 'X') ||
                    (!main && map[i][checkLength- i] == 'X')){
                lineLength++;
            } else if (previousX == -1) {
                previousX = i;
                previousY = main ? i : checkLength- i;
            } else if (lineLength != DOTS_TO_WIN - 1) return false;

        }

        if ((lineLength == DOTS_TO_WIN - 1) && isCellEmpty(previousY, previousX)) {
            map[previousX][previousY] = 'O';
            currentX = previousX;
            currentY = previousY;
            return true;
        }
        return false;
    }

    // Ищется лучший ход по диагонали, расположенной слева или справа от главной в зависимости от параметра left
    public static boolean findBestMoveLeftRightMainDiagonal(boolean left) {

        if ((left && currentX <= currentY) ||
                (!left && currentX >= currentY)) return false;

        int previousX = -1;
        int previousY = -1;
        int lineLength = 0;
        int difference = left ? currentX - currentY : currentY - currentX;
        for (int x = left ? currentX - currentY : 0; left ? x < SIZE : x + difference < SIZE; x++) {

            if ((left && map[x][x-difference] == 'X') ||
                    (!left && map[x][x+difference] == 'X')){
                lineLength++;
            } else if (previousX == -1) {
                previousX = x;
                previousY = left ? x-difference : x+difference;
            } else if (lineLength != DOTS_TO_WIN - 1) return false;

        }

        if ((lineLength == DOTS_TO_WIN - 1) && isCellEmpty(previousY, previousX)) {
            map[previousX][previousY] = 'O';
            currentX = previousX;
            currentY = previousY;
            return true;
        }
        return false;
    }
//x 0 1 2

//    y
//    0
//    1
//    2
    public static boolean isCellEmpty(int x, int y) { // проверка является ли ячейка свободной
        if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) return false; // если указаны неверные координаты, считаем что ячейка условно занята
        if (map[y][x] != '*') return false; // если в ячейке не *, значит занята
        return true; // ячейка свободна
    }


}
