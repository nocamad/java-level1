package ru.geekbrains.java1.dz.dz4.RoumyantsevPA;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int MAX = 3;          //Размеры игрового поля
    public static int toWin = 3;        //количество элементов в ряд, для победы
    public static int realToWin;        //в ходе программы, будем менять toWin. чтобы вернуть исходное значение
    public static char matrix[][];
    public static char EMPTY = '*';
    public static char X = 'X';
    public static char O = 'O';
    public static int Oi;               //Координата куда поставить О при работе Ai
    public static int Oj;
    public static int Fx;               //Поиск первого крестика
    public static int D;                //Количество диагоналей в строке
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static int nom;


    public static void main(String[] args) {
        System.out.println("Введите размеры поля: ");
        MAX = next();

        System.out.println("Введите количество элементов для победы:");


        for (; ; ) {
            toWin = next();
            if (toWin <= MAX) {         //Проверка корректности ввода
                break;
            }
        }

        nom = 0;            //Переключатель первого хода Пользователь/Ai
        int pWin = 0;           //Счетчик побед игрока
        int aiWin = 0;          //Счетчик побед Ai

        for (; ; ) {
            initGame();
            printMatrix();

            for (; ; ) {

                if (nom % 2 == 0) {
                    playerTurn();
                    if (checkWin(X)) {
                        System.out.println("Игрок победил!");
                        pWin++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья!");
                        break;
                    }
                    aiTurn();
                    if (checkWin(O)) {
                        System.out.println("Скайнет празднует победу!");
                        aiWin++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья!");
                        break;
                    }
                } else {
                    // Fx += 5;
                    aiTurn();
                    if (checkWin(O)) {
                        System.out.println("Скайнет празднует победу!");
                        aiWin++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья!");
                        break;
                    }
                    playerTurn();
                    if (checkWin(X)) {
                        System.out.println("Игрок победил!");
                        pWin++;
                        break;
                    }
                    if (checkDraw()) {
                        System.out.println("Ничья!");
                        break;
                    }
                }
            }
            nom++;
            System.out.println("Результат по партиям: Игрок: " + pWin + " Скайнет: " + aiWin);
            System.out.println("Играем еще раз? 0-нет");


            if (next() == 0) {
                break;
            }

        }

    }

    public static void initGame() {
        Fx = 0;
        D = 1;
        realToWin = toWin;
        for (int i = toWin; i < MAX; i++) {
            D++;
        }
        matrix = new char[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matrix[i][j] = EMPTY;
            }
        }


    }

    public static void printMatrix() {
        for (int i = 0; i < MAX + 1; i++) {

            System.out.print(i + " ");

        }
        System.out.println();
        for (int i = 0; i < MAX; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAX; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void playerTurn() {
        Fx++;
        int x, y;
        for (; ; ) {

            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
//            x=next();
//            y=next();
            if ((x >= 0 && x <= MAX - 1) && (y >= 0 && y <= MAX - 1)) {
                if (matrix[y][x] == EMPTY) {
                    matrix[y][x] = X;
                    break;
                }
            }


        }
        Oi = y;     //Подсматриваем куда сходил игрок
        Oj = x;
        System.out.println("Игрок сходил: " + (x + 1) + " " + (y + 1));
        printMatrix();
    }

    public static boolean checkDraw() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (matrix[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void aiTurn() {
        int x = -1;
        int y = -1;
        if ((MAX - 1) % 2 == 0 && matrix[MAX / 2][MAX / 2] == EMPTY) {  //если есть центр и он пуст, ставим О туда
            x = MAX / 2;
            y = MAX / 2;
        } else if (Fx == 1 && nom % 2 == 0) {                                           //если наш ход 2 и на поле только 1 крестик, ставим О по диагонали от него
            if (Oi + 1 < MAX && Oj + 1 < MAX)
                if (matrix[Oi + 1][Oj + 1] == EMPTY) {
                    x = Oj + 1;
                    y = Oi + 1;
                }
            if (Oi + 1 < MAX && Oj - 1 >= 0)
                if (matrix[Oi + 1][Oj - 1] == EMPTY) {
                    x = Oj - 1;
                    y = Oi + 1;
                }
            if (Oi - 1 >= 0 && Oj - 1 >= 0)
                if (matrix[Oi - 1][Oj - 1] == EMPTY) {
                    x = Oj - 1;
                    y = Oi - 1;
                }
            if (Oi - 1 >= 0 && Oj + 1 < MAX)
                if (matrix[Oi - 1][Oj + 1] == EMPTY) {
                    x = Oj + 1;
                    y = Oi - 1;
                }
        } else if (Fx == 2 && nom % 2 == 0 && MAX == 3 && matrix[2][0] == X) {
            y = 0;
            x = 0;

        } else if (Fx == 1 && MAX == 3 && nom % 2 != 0 && (matrix[1][0] == X || matrix[0][1] == X || matrix[2][1] == X || matrix[1][2] == X)) {
            if (matrix[1][0] == X||matrix[0][1] == X) {
                x = 2;
                y = 2;
            } else {                                                        //Ловим игрока
                x = 0;
                y = 0;
            }
        } else if (blockPlayer()) {                                     //Блокировка хода игрока
            y = Oi;
            x = Oj;
        } else {                                                        //Попытка сделать неплохой ход
            toWin--;
            for (; toWin > 0; toWin--) {
                if (blockPlayer()) {
                    y = Oi;
                    x = Oj;
                    break;
                }
            }
            toWin = realToWin;
        }

        if (x == -1) {                                                  //Случайный ход
            for (; ; ) {
                x = rand.nextInt(MAX);
                y = rand.nextInt(MAX);
                if (matrix[y][x] == EMPTY) {
                    matrix[y][x] = O;
                    break;
                }
            }
        }


        matrix[y][x] = O;
        System.out.println("Скайнет сходил: " + (x + 1) + " " + (y + 1));
        printMatrix();

    }

    public static boolean checkWin(char c) {

//       //горизонталь
//
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX - toWin + 1; j++) {
                int win = 0;
                for (int s = 0; s < toWin; s++) {
                    if (matrix[i][j + s] == c) {
                        win++;
                    }
                }
                if (win >= toWin) {

                    return true;
                }
            }
        }
//
//        //вертикаль
//
        for (int i = 0; i < MAX - toWin + 1; i++) {
            for (int j = 0; j < MAX; j++) {
                int win = 0;
                for (int s = 0; s < toWin; s++) {
                    if (matrix[i + s][j] == c) {
                        win++;
                    }
                }
                if (win >= toWin) {

                    return true;
                }
            }
        }


        //диагональ \

        for (int i = 0; i < MAX - toWin + 1; i++) {
            for (int j = 0; j < MAX - toWin + 1; j++) {
                int win = 0;

                for (int s = 0; s < toWin; s++) {

                    if (matrix[i + s][j + s] == c) {
                        win++;
                    }
                }
                if (win >= toWin) {

                    return true;
                }
            }
        }

        //диагональ /

        for (int i = MAX - D; i < MAX; i++) {
            for (int j = 0; j < D; j++) {
                int win = 0;
                for (int s = 0; s < toWin; s++) {
                    if (matrix[i - s][j + s] == c) {
                        win++;
                    }

                }

                if (win >= toWin) {

                    return true;
                }

            }
        }

        return false;
    }


    public static boolean blockPlayer() {


        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (matrix[i][j] == EMPTY) {
                    matrix[i][j] = O;
                    if (checkWin(O)) {
                        Oj = j;
                        Oi = i;
                        matrix[i][j] = EMPTY;
                        return true;
                    } else {
                        matrix[i][j] = EMPTY;
                    }
                }
            }

        }

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (matrix[i][j] == EMPTY) {
                    matrix[i][j] = X;
                    if (checkWin(X)) {
                        Oj = j;
                        Oi = i;
                        matrix[i][j] = EMPTY;
                        return true;
                    } else {
                        matrix[i][j] = EMPTY;
                    }
                }
            }
        }
        return false;


    }

    public static int nextInt() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        return i;

    }

    public static int next() {
        int i;
        for (; ; ) {
            try {
                i = nextInt();
                break;
            } catch (Exception e) {
            }

        }

        return i;
    }
}

