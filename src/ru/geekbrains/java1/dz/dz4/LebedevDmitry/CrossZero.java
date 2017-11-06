package ru.geekbrains.java1.dz.dz4.LebedevDmitry;

import java.util.Random;
import java.util.Scanner;

public class CrossZero {

    private static final char EMPTY_SIGN = '*';             // Заполнитель пустой ячейки
    private static final char X_SIGN = 'X';                 // Заполнитель ячейки Х
    private static final char O_SIGN = 'O';                 // Заполнитель ячейки О
    private static int size;                                // размер игрового поля
    private static int dotsToWin;                           // длина выигрышной последовательности
    private static char[][] map;                            // игровое поле
    private static Scanner sc = new Scanner(System.in);     // Scanner для чтения консоли
    private static Random rand = new Random();              // генератор случайных чисел

    // метод инициализирует массив map(игровое поле указанного размера) и длину выигрышной последовательности
    private static void initMap(int size,int dotsToWin) {
        CrossZero.size = size;
        CrossZero.dotsToWin = dotsToWin;
        map = new char[size][size];
        for (int i = 0; i < size; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY_SIGN; // и заполняем каждую ячейку *
            }
        }
    } //initMap

    // метод выводит игровое поле в консоль
    private static void printMap() {
        StringBuilder heading = new StringBuilder("0");
        for (int i = 1; i <= size; i++) { // сборка строки заголовка
            heading.append(" ");
            heading.append(i);
        } //for
        System.out.print(heading + "\n"); // первая строка с координатами
        for (int i = 0; i < size; i++) { // начинаем печатать поле
            System.out.print((i + 1) + " "); // ставим номер строки
            for (int j = 0; j < size; j++) { // начинаем печатать строку
                System.out.print(map[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
            } //for
            System.out.println(); // после распечатки строки, делаем перевод каретки
        } //for
        System.out.println(); // делаем дополнительный перевод строки
    } //printMap

    // метод проверяет условия победы и завершает игру при их выполнении
    // *проверяет главную и побочную диагонали c паралльльными
    private static boolean isCheckWin(char c) {

        // Ищем заполненные горизонтальные линии
        for (int i = 0; i < size; i++) {
            int count = 0; // счетчик последовательно поставленных символов X или O
            for (int j = 0; j < size; j++) {
                if (map[i][j] == c) { //если проверяемая ячейка совпадает с с - увечличиваем счетчик на 1
                    count++;
                } else { // иначе начинаем счет заново
                    count = 0;
                }
                if (count == dotsToWin) { //если количество последовательных элементов = нужному для выигрыша
                    return true; //победа
                }//if
            }// for
        } //for

        // Ищем заполненные вертикальные линии
        for (int j = 0; j < size; j++) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (map[i][j] == c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == dotsToWin) {
                    return true;
                }//if
            }// for
        } //for

        // Главная диагональ и параллельные
        // паралльельные проверяются только в том случае, если там сможет поместиться выигрышная последовательность
        for (int i = 0; i <= size - dotsToWin; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < size - i; j++) {
                if (map[i + j][j] == c) {//элементы ниже гл. диагонали
                    count1++;
                } else {
                    count1 = 0;
                }
                if (map[j][i + j] == c) {//элементы выше гл. диагонали
                    count2++;
                } else {
                    count2 = 0;
                }
                if (count1 == dotsToWin || count2 == dotsToWin) {
                    return true;
                } //if
            } //for
        } //for

        // Побочная диагональ и параллельные
        for (int i = dotsToWin - 1; i < size; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j <= i; j++) {
                if (map[i - j][j] == c) {//элементы выше побочн. диагонали
                    count1++;
                } else {
                    count1 = 0;
                }
                if (map[(size - 1) - j][(size - 1) - i + j] == c) {//элементы ниже побочн. диагонали
                    count2++;
                } else {
                    count2 = 0;
                }
                if (count1 == dotsToWin || count2 == dotsToWin) {
                    return true;
                } //if
            } //for
        } //for
        return false; // если ни одной линии не нашли, значит игрок еще не победил
    } //isCheckWin

    // с помощью метода выполняется ход человека
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку
        map[y][x] = X_SIGN; // после чего ставим туда Х
    } //humanTurn

    // с помощью метода выполняется хот AI
    // *проверяет только главную и побочную диагонали без паралльльных
    private static void aiTurn() {
        int x, y;
        int count;
        // Ищем заполненные горизонтальные линии
        for (int i = 0; i < size; i++) {
            count = 0; // счетчик последовательно поставленных символов X
            y = i; // номер строки
            x = size - 1; // максимальное значение в строке - если пустое место есть раньше, оно заменяется
            for (int j = 0; j < size; j++) {
                if (map[i][j] == X_SIGN) {
                    count++; //если проверяемая ячейка совпадает с X - увечличиваем счетчик на 1
                } else {
                    x = j;
                }//if
                if (count == dotsToWin - 1) { //если количество последовательных элементов меньше необходимого на 1
                    map[y][x] = O_SIGN; //ai ставит в пустое место знак O
                    return;
                }//if
            }// for
        } //for

        // Ищем заполненные вертикальные линии
        for (int j = 0; j < size; j++) {
            count = 0; // счетчик последовательно поставленных символов X
            x = j; //номер столбца
            y = size - 1; // максимальное значение в столбце - если пустое место есть раньше, оно заменяется
            for (int i = 0; i < size; i++) {
                if (map[i][j] == X_SIGN) {
                    count++; //если проверяемая ячейка совпадает с X - увечличиваем счетчик на 1
                } else {
                    y = i;
                }//if
                if (count == dotsToWin - 1) { //если количество последовательных элементов меньше необходимого на 1
                    map[y][x] = O_SIGN; //ai ставит в пустое место знак O
                    return;
                }//if
            }// for
        } //for

        // Главная диагональ
        count = 0;
        x = size - 1;
        y = size - 1;
        for (int i = 0; i < size; i++) {
            if (map[i][i] == X_SIGN) {
                count++;
            } else {
                x = y = i;
            } //if else
            if (count == dotsToWin - 1) {
                map[y][x] = O_SIGN; //ai ставит в пустое место знак O
                return;
            } //if
        } //for

        // Побочная диагональ
        count = 0;
        x = 0;
        y = size - 1;
        for (int i = 0; i < size; i++) {
            if (map[i][(size - 1) - i] == X_SIGN) {
                count++;
            } else {
                x = size - 1 - i;
                y = i;
            } //if else
            if (count == dotsToWin - 1) {
                map[y][x] = O_SIGN; //ai ставит в пустое место знак O
                return;
            } //if
        } //for
        do { // компьютер пытается случайно выбрать незанятое поле для хода
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellEmpty(x, y));
        map[y][x] = O_SIGN; // как только ячейка найдена, ставим туда О
    } //aiTurn

    // метод проверяет, заполнено ли все поле знаками X и O
    private static boolean isMapFull() {
        for (char row[] : map) {
            for (char cell : row) {
                if (cell == EMPTY_SIGN)
                    return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
            } //for
        } //for
        return true;
    } //isMapFull

    // метод проверяет, является ли ячейка свободной
    private static boolean isCellEmpty(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && map[y][x] == EMPTY_SIGN;
    } //isCellEmpty

    // открытый метод запуска игры
    public static void theGame(int size, int dotsToWin){
        initMap(size, dotsToWin); // инициализируем поле
        printMap(); // печатаем в консоль

        while (true) { // запускаем игровой цикл
            humanTurn(); // ход человека
            printMap(); // печать поля
            if (isCheckWin(X_SIGN)) { // проверка победы человека
                System.out.println("Победил игрок");
                break;
            } //if
            if (isMapFull()) break; // если поле заполнилось, завершаем игру
            aiTurn(); // ход компьютера
            printMap(); // печать поля
            if (isCheckWin(O_SIGN)) { // проверка победы компьютера
                System.out.println("Победил компьютер");
                break;
            } //if
            if (isMapFull()) break;
        } //while
        System.out.println("Game Over");
    } //theGame

    public static void main(String[] args) {
        theGame(4,4);
    } //main
}