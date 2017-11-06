package ru.geekbrains.java1.dz.dz4.lobysheva;

/*
 * Created by Oxana Lobysheva on 22.10.2017.
 */

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson4 {

    public static char[][] map;
    public static char[][] reversedMap;
    public static char[][] reversedMapDiagonal;

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static SecureRandom rand = new SecureRandom();


    public static void main(String[] args) {

        try {
            System.out.println("******************************");
            System.out.println("  Lets play! Cross-zero game");
            System.out.println("******************************");

            initMaps();
            printMap();

            while (true) {
                playerTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("          HUMAN BEING won");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("            NOBODY won");
                    break;
                }
                computerTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("            SKYNET won");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("            NOBODY won");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error. Input Mismatch Exception");
        } finally {
            System.out.println("*******************************");
            System.out.println("            Game over");
            System.out.println("*******************************");
            sc.close();
        }
    }

    private static void initMaps() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        reversedMap = new char[SIZE][SIZE];
        reversedMapDiagonal = new char[SIZE][SIZE];
    }

    private static void printMap() {
        System.out.println();
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void reverseMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                reversedMap[k][i] = map[i][k];
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                reversedMapDiagonal[i][SIZE-k-1] = map[i][k];
            }
        }
    }

    private static boolean checkWin(char symb) {
        reverseMap();
        if (checkMapLine(map, symb) || checkMapLine(reversedMap, symb)
                || checkMapDiagonal(map, symb) || checkMapDiagonal(reversedMapDiagonal, symb)) {
            return true;
        }
        return false;
    }

    private static boolean checkMapLine(char[][] mapForCheck, char symb){
        for (int i = 0; i < SIZE; i++){
            int count = 0;
            int maxCount = 0;
            for (int k=0; k < SIZE; k++){
                if (mapForCheck[i][k] == symb)  {
                    count++;
                    if (count > maxCount){
                        maxCount = count;
                    }
                } else {
                    count = 0;
                }
            }
            if (maxCount >= DOTS_TO_WIN) return true;
        }
        return false;
    }

    private static boolean checkMapDiagonal(char[][] mapForCheck, char symb){
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < SIZE; i++){
            if (mapForCheck[i][i] == symb) {
                count++;
                if (count > maxCount){
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        if (maxCount >= DOTS_TO_WIN) return true;
        return false;
    }


    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    private static void playerTurn() {
        int x, y;
        do {
            System.out.println("Your turn: X Y ?");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static int[] getBlockedLine(char[][] mapForCheck){
        int[] res = {-1, 0};
        for (int i = 0; i < SIZE; i++) {
            int countDotO = 0;
            int countDotX = 0;
            int countDotEmpty = 0;
            for (int k=1; k < SIZE-1; k++){
                switch (mapForCheck[i][k]) {
                    case DOT_X:
                        countDotX++;
                        break;
                    case DOT_O:
                        countDotO++;
                        break;
                    case DOT_EMPTY:
                        countDotEmpty++;
                        break;
                }
            }
            if (countDotO == 0 && countDotX > 0 && countDotEmpty > 0) {
                res[0] = i;
                res[1] = countDotX;
                return res;
            }
        }
        return res;
    }

    private static int[] getBlockedDiagonal(char[][] mapForCheck){
        int[] res = {-1, 0};
        int countDotO = 0;
        int countDotX = 0;
        int countDotEmpty = 0;
        for (int i = 1; i < SIZE - 1; i++) {
            switch (mapForCheck[i][i]) {
                case DOT_X:
                    countDotX++;
                    break;
                case DOT_O:
                    countDotO++;
                    break;
                case DOT_EMPTY:
                    res[0] = i;
                    countDotEmpty++;
                    break;
            }
            res[1] = countDotX;
        }
        if (!(countDotO == 0 && countDotX > 0 && countDotEmpty > 0)) {
            res[0] = -1;
            res[1] = 0;
            return res;
        }
        return res;
    }

    private static void computerTurn() {
        int x, y;

        int[] blocked_y = getBlockedLine(map);
        int[] blocked_x = getBlockedLine(reversedMap);
        int[] blocked_y_diagonal = getBlockedDiagonal(reversedMapDiagonal);
        int[] blocked_x_diagonal = getBlockedDiagonal(map);


        if (blocked_y[1] >= blocked_x[1]) {
            blocked_x[0] = -1;
        } else {
            blocked_y[0] = -1;
        }

        if (blocked_y_diagonal[1] >= blocked_x_diagonal[1]) {
            blocked_x_diagonal[0] = -1;
        } else {
            blocked_y_diagonal[0] = -1;
        }

        do {
            if (blocked_x_diagonal[0] >= 0) {

                x = y = blocked_x_diagonal[0];

            } else if (blocked_y_diagonal[0] >= 0){

                y = blocked_y_diagonal[0];
                x = SIZE - blocked_y_diagonal[0] - 1;

            } else if (blocked_x[0] >= 0)  {

                x = blocked_x[0];
                y = rand.nextInt(SIZE-2)+1;

            } else if (blocked_y[0] >= 0) {

                x = rand.nextInt(SIZE-2)+1;
                y = blocked_y[0];

            } else {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        } while (!isCellValid(x, y));
        System.out.println("Skynet turn: X = " + (x + 1) + " Y = " + (y + 1));
        map[y][x] = DOT_O;
    }

}
