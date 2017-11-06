package ru.geekbrains.java1.dz.dz4.beloborodovdv;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static char[][] arrayMap;
    private static char[] arrayTemp;
    private static final int SIZE_MAP = 5; //размер поля
    private static final int DOT_COUNT_VICTORY = 4 ; //количество фишек для выигрыша
    private static Scanner sc = new Scanner(System.in);
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_FREE = '*';
    private static int coordinateX = 0;
    private static int coordinateY = 0;

    // Заполнение данными матрицу
    private static void fillArrayMap(int sizeMap) {
        arrayMap = new char[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                arrayMap[i][j] = DOT_FREE;
            }
        }
    }


    // прорисовка поля
    private static void printMap(int sizeMap) {

        for (int i = 0; i < sizeMap + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }

            for (int j = 1; j < sizeMap + 1; j++) {
                if (i > 0) {
                    System.out.print(arrayMap[i - 1][j - 1] + " ");
                } else {
                    System.out.print(j + " ");
                }

            }
            System.out.println("");
        }

    }

    //свободна ли клетка
    private static boolean isFree(int x, int y) {
        return (arrayMap[y - 1][x - 1]) != DOT_FREE;
    }

    //ход игрока
    private static void turnGamer() {

        System.out.println("Введите номер клетки x и y  d пределах от " + "1 до " + SIZE_MAP);
        int x;
        int y;
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (!(x < 0 || x > SIZE_MAP || y < 1 || y > SIZE_MAP || isFree(x, y))) {
                break;
            } else {
                System.out.println("Число не правильное или клетка занята , повторите");
            }
        }

        arrayMap[y - 1][x - 1] = DOT_X;

    }

    //поиск следующего хода

    private static boolean returnNextTurnPC(char[] arrayTemp){
        int countX;
        boolean labelX = false;
        int startX = 0;


        for (int i = 0; i<SIZE_MAP-DOT_COUNT_VICTORY+1; i++){
             countX = 0;
            labelX = false;
            for (int j = i; j<i+DOT_COUNT_VICTORY; j++){
               if(arrayTemp[j] == DOT_X) {
                   countX ++;
               }
               if (arrayTemp[j] == DOT_O){
                   countX --;
               }
            }
            if (countX == DOT_COUNT_VICTORY-1){
                labelX = true;
                startX = i;
                System.out.println("FFFF = "+i);
                break;
            }
        }
        if (labelX){
            for (int i = startX; i<startX+DOT_COUNT_VICTORY; i++){
                if (arrayTemp[i] == DOT_FREE){
                    coordinateX = i;
                    return  true;
                }
            }
        }
        return false;
    }


    //ход компьютера
    private static void turnPC() {

        boolean label =false;
        arrayTemp =new char[SIZE_MAP];
        //  проверка по X
        for (int i = 0; i <SIZE_MAP; i++) {
            for (int j =0; j <SIZE_MAP; j++){
                arrayTemp[j] = arrayMap[i][j];
            }
            if (returnNextTurnPC(arrayTemp)) {
                label = true;

                coordinateY=i;
                System.out.println("corX = "+ coordinateX );
                System.out.println("corY = "+ coordinateY);

                arrayMap[coordinateY][coordinateX] = DOT_O;
                System.out.println("Sdfgdg");
                break;
            };
            //System.out.println(Arrays.toString(arrayTemp));
        }
        //проверка по Y
        for (int i = 0; i <SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                arrayTemp[j] = arrayMap[j][i];
            }
            if (returnNextTurnPC(arrayTemp)) {
                label = true;

                coordinateY = i;
                System.out.println("corX = " + coordinateY);
                System.out.println("corY = " + coordinateX);

                arrayMap[coordinateX][coordinateY] = DOT_O;
                break;
            }

        }
// проверка по главной диагонали
            for (int i = 0; i <SIZE_MAP; i++) {
                for (int j = 0; j < SIZE_MAP; j++) {
                    arrayTemp[j] = arrayMap[j][j];
                }
                if (returnNextTurnPC(arrayTemp)) {
                    label = true;

                    coordinateY = i;
                    System.out.println("corX = " + coordinateY);
                    System.out.println("corY = " + coordinateX);

                    arrayMap[coordinateX][coordinateX] = DOT_O;
                    break;
                }

            }
// проверка по второстипенной  диагонали
        for (int i = 0; i <SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                arrayTemp[j] = arrayMap[SIZE_MAP-j-1][j];
            }
            if (returnNextTurnPC(arrayTemp)) {
                label = true;

                coordinateY = i;
                int temp = SIZE_MAP - coordinateX;
                System.out.println("corX = " + temp);
                System.out.println("corY = " + coordinateX);

                arrayMap[SIZE_MAP - coordinateX-1][coordinateX] = DOT_O;
                break;
            }

        }



        if (!label) {
            int x, y;
            do {
                x = (int) (Math.random() * SIZE_MAP + 1);
                y = (int) (Math.random() * SIZE_MAP + 1);
                System.out.println("x="+x+" y="+y);
            } while (isFree(x, y));

            arrayMap[y - 1][x - 1] = DOT_O;
        }

    }

    //проверка выигрыша
    private static boolean isVictory() {
        //проверка по строкам и столцам
        int xX;
        int yX;
        int xO;
        int yO;
        int d1X = 0;
        int d2X = 0;
        int d1O = 0;
        int d2O = 0;
        int countFree = 0;
        for (int i = 0; i < SIZE_MAP; i++) {
            xX = 0;
            xO = 0;
            yX = 0;
            yO = 0;
//проверка по диаганалям
            if (arrayMap[i][i] == DOT_X) d1X++;
            else d1X = 0;
            if (arrayMap[i][i] == DOT_O) d1O++;
            else d1O = 0;
            if (arrayMap[i][SIZE_MAP - i - 1] == DOT_X) d2X++;
            else d2X = 0;
            if (arrayMap[i][SIZE_MAP - i - 1] == DOT_O) d2O++;
            else d2O = 0;


            for (int j = 0; j < SIZE_MAP; j++) {
                //проверка по x и y
                if (arrayMap[i][j] == DOT_FREE) countFree++;
                if (arrayMap[i][j] == DOT_X) xX++;
                else xX = 0;
                if (arrayMap[i][j] == DOT_O) xO++;
                else xO = 0;
                if (arrayMap[j][i] == DOT_X) yX++;
                else yX = 0;
                if (arrayMap[j][i] == DOT_O) yO++;
                else yO = 0;


                if (xX >= DOT_COUNT_VICTORY || yX >= DOT_COUNT_VICTORY || d1X >= DOT_COUNT_VICTORY || d2X >= DOT_COUNT_VICTORY) {
                    System.out.println("Победа игрока");
                    return true;
                }

                if (xO >= DOT_COUNT_VICTORY || yO >= DOT_COUNT_VICTORY || d1O >= DOT_COUNT_VICTORY || d2O >= DOT_COUNT_VICTORY) {
                    System.out.println("Победа ПК");
                    return true;
                }


            }
        }
        if (countFree == 0) {
            System.out.println("Ничья");
            return true;
        }


        return false;
    }

    public static void main(String[] args) {

        fillArrayMap(SIZE_MAP);
        printMap(SIZE_MAP);
        while (true) {
            turnGamer();
            printMap(SIZE_MAP);
            if (isVictory()) {
                break;
            }
            turnPC();
            printMap(SIZE_MAP);
            if (isVictory()) {
                break;
            }
        }


    }
}
