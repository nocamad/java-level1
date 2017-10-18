package ru.geekbrains.java1.dz.dz2.DunaevArtur;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] bits = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        System.out.println( "1. Задан целочисленный массив: " + Arrays.toString(bits) );
        invertBits(bits);
        System.out.println( "   Массив после замены:        " + Arrays.toString(bits) );


        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
        // 0 3 6 9 12 15 18 21;
        int[] arr1 = new int[8];

        System.out.println( "2. Задан пустой целочисленный массив: " + Arrays.toString(arr1) );
        fillArr(arr1);
        System.out.println( "   Массив после заполнения:           " + Arrays.toString(arr1) );
        

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        // умножить на 2;
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println( "3. Задан целочисленный массив: " + Arrays.toString(arr2) );
        changeArr(arr2);
        System.out.println( "   Массив после изменения:     " + Arrays.toString(arr2) );


        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с
        // помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int n = 5;
        int[][] arr3 = new int[n][n];

        fillX(arr3, n);
        System.out.println( "4. Квадратный двумерный массив:" );

        for (int i = 0; i < n; i++) {
            System.out.println( "   " + Arrays.toString(arr3[i]) );
        }


        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arr4 = { 3, 8, 54, 0, -5, 32, 4};

        System.out.println( "5. ** Минимальный и максимальный элементы мыассива (функции интернет не используют): "
                + minNumArr(arr4) + " и " + maxNumArr(arr4) );


        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
        // вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
        //          checkBalance ([2, 1, 1, 2, 1]) → false,
        //          checkBalance ([10, || 10]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] arr5 = { 3, 8, 4, 43, 9, 2, 4, 83, 194, 12 };
        //int[] arr5 = new int[5];
        //int[] arr5 = { 1, 1, 1, 2, 1 };
        //int[] arr5 = { 2, 1, 1, 2, 1 };
        //int[] arr5 = { 10, 10 };

        System.out.println( "6. ** В массиве" + (checkBalance(arr5) ? " есть " : " нет ") + "место(а), в котором сумма левой и правой части равны" );


        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
        // нельзя пользоваться вспомогательными массивами.
        int[] arr6 = { 5, 3, 56, 9, 32, 1 };
        //int[] arr6 = { 6, 3 };
        //int[] arr6 = new int[5];
        int num = -2;

        offsetArray(arr6, num);
        System.out.println( "7. **** Массив после смещения: " + Arrays.toString(arr6) );


        System.out.println( "\nThe End!" );

    }

    // for task 7****
    private static void offsetArray(int[] arr, int num) {

        int length = arr.length;
        int buff;

        if (num > 0) {

            for (int i = 0; i < num; i++) {

                buff = arr[length - 1];

                for (int j = length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[0] = buff;

            }

        } else if (num < 0) {

            for (int i = -num; i > 0; i--) {

                buff = arr[0];

                for (int j = 0; j < length -1; j++) {
                    arr[j] = arr[j + 1];
                }

                arr[length - 1] = buff;
            }

        }

    }

    // for task 6**
    private static boolean checkBalance(int[] arr) {
        int oneSum, twoSum;
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            oneSum = 0;
            twoSum = 0;

            for (int j = 0; j <= i; j++) {
                oneSum += arr[j];
            }

            for (int j = i + 1; j < length; j++) {
                twoSum += arr[j];
            }

            if (oneSum == twoSum) return true;

        }

        return false;

    }

    // for task 5**
    private static int minNumArr(int[] arr) {

        int[] arr1 = arr;

        Arrays.sort(arr1);

        return arr1[0];

    }

    // for task 5**
    private static int maxNumArr(int[] arr) {

        int[] arr1 = arr;

        Arrays.sort(arr1);

        return arr1[arr.length-1];

    }

    // for task 4
    private static void fillX(int[][] arr, int n) {

        for (int i = 0, j = n-1; i < n; i++, j--) {
            arr[i][i] = 1;
            arr[i][j] = 1;
        }

    }

    // for task 3
    private static void changeArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 6) {
                arr[i] *= 2;
            }

        }

    }

    // for task 2
    private static void fillArr(int[] arr) {

        for (int i = 0, j = 0; i < arr.length; i++, j = i * 3) {
            arr[i] = j;
        }

    }

    // for task 1
    private static void invertBits(int[] bits) {

        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] == 1 ? 0 : 1);
        }

    }

}
