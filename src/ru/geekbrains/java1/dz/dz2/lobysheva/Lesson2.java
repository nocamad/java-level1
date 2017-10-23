package ru.geekbrains.java1.dz.dz2.lobysheva;

import java.util.Arrays;

/**
 * Created by Oxana Lobysheva on 15.10.2017.
 */

public class Lesson2 {

    public static void main(String[] args){

        int[] arrayTask1 = {1, 1, 0, 0, 1, 1, 0, 1};
        reverseInt(arrayTask1);
        System.out.println("Заменить 0 на 1 и 1 на 0 в массиве. Результат: " + Arrays.toString(arrayTask1));

        int[] arrayTask2 = new int[8];
        fillArray(arrayTask2);
        System.out.println("Заполнить массив. Результат: " + Arrays.toString(arrayTask2));

        int[] arrayTask3 = {1, 5, 3, 0, 11, 4, 5, 2, -4, 8, 9, 1};
        updateArray(arrayTask3);
        System.out.println("Увеличить в 2 раза значения меньше 6. Результат: " + Arrays.toString(arrayTask3));

        int arraySize = 9;
        int[][] arrayTask4 = createSquareArray(arraySize);
        System.out.println("Создать квадратный двумерный массив с 1 по диагонали. Размер массива = " + arraySize);
        for (int i = 0; i < arraySize; i++){
            System.out.println(Arrays.toString(arrayTask4[i]));
        }

        int[] arrayTask5 = {1, 3, -66, 7, 10, 66, 5, 0, 3, 8, 66, 1};
        System.out.println("Найти мин и макс в массиве. Результат: " + getMaxAndMinValue(arrayTask5));

        int[] arrayTask6 = {1, 0, -1, 1, 1, 2, -1, 1};
        System.out.println("Есть точка баланса в массиве? " + checkBalance(arrayTask6));

        int[] arrayTask7 = {1, 5, 3, 7, 0, 44, -2, 11, -4};
        int step = -2;
        shiftElements(arrayTask7,step);
        System.out.println("Сместить позицию элементов массива на " + step + ". Результат: "  + Arrays.toString(arrayTask7));

    }



    private static void reverseInt(int[] arrayInitial){
        for (int i = 0; i < arrayInitial.length; i++){
            if (arrayInitial[i] == 0){
                arrayInitial[i] = 1;
            } else {
                arrayInitial[i] = 0;
            }
        }
    }

    private static void fillArray(int[] arrayInitial){
        for (int i = 0; i < arrayInitial.length; i++){
            arrayInitial[i] = i * 3;
        }
    }

    private static void updateArray(int[] arrayInitial){
        for (int i = 0; i < arrayInitial.length; i++){
            if (arrayInitial[i] < 6){
                arrayInitial[i] *= 2;
            }
        }
    }

    private static int[][] createSquareArray(int size){
        if (size < 0) return new int[0][0];
        int[][] arrayCreated = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i == j || ( i + j == (size-1))){
                    arrayCreated[i][j] = 1;
                }
            }
        }
        return arrayCreated;
    }

    private static String getMaxAndMinValue(int[] arrayInitial){
        if (arrayInitial.length < 1) return "Массив пустой";
        int maxValue = arrayInitial[0];
        int minValue = arrayInitial[0];
        for (int i : arrayInitial){
            if (i > maxValue){
                maxValue = i;
            }
            if (i < minValue){
                minValue = i;
            }
        }
        return "Max = " + maxValue + " Min = " + minValue;
    }

    private static boolean checkBalance(int[] arrayInitial){
        int size = arrayInitial.length;
        if (size < 2) return false;
        for (int i = 0; i < (size-1); i++){
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0;j <= i; j++) {
                sumLeft += arrayInitial[j];
            }
            for (int k = size-1; k > i; k--) {
                sumRight += arrayInitial[k];
            }
            if (sumLeft == sumRight){
                return true;
            }
        }
        return false;
    }

    private static void shiftElements(int[] arrayInitial, int step){
        int size = arrayInitial.length;
        if (step < 0){
            for (int i = 0; i < size; i++){
                if ( i-step < size){
                    arrayInitial[i] = arrayInitial[i-step];
                } else {
                    arrayInitial[i] = 0;
                }
            }
        } else {
            for (int j = size-1; j >= 0; j--){
                if (j-step >= 0){
                    arrayInitial[j] = arrayInitial[j-step];
                } else {
                    arrayInitial[j] = 0;
                }
            }
        }
    }

}

