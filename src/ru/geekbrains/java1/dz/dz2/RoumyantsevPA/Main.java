package ru.geekbrains.java1.dz.dz2.RoumyantsevPA;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //   1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr1) + "\n");

        //2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2) + "\n");

        //3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3) + "\n");

        //4 Создать квадратный двумерный целочисленный массив (количество строк и столбцоводинаковое), и с помощью
        // цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println(" ");
        //System.out.println(Arrays.deepToString(arr4)+"\n");

        //5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (безпомощи интернета);

        int[] arr5 = new int[8];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = (int) (Math.random() * 50);
        }
        System.out.println(Arrays.toString(arr5));
        int maxIndex = 0;
        int maxValue = arr5[0];
        int minIndex = 0;
        int minValue = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > arr5[maxIndex]) {
                maxIndex = i;
                maxValue = arr5[i];
            }
            if (arr5[i] < arr5[minIndex]) {
                minIndex = i;
                minValue = arr5[i];
            }
        }
        System.out.println("max[" + maxIndex + "] = " + maxValue);
        System.out.println("min[" + minIndex + "] = " + minValue + "\n");

        //6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,метод должен вернуть true
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) →false,
        // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.

        int[] arr6 = {1, 1, 1, 2, 1};
//        int[] arr6 = new int[8];
//        for (int i=0;i<arr6.length;i++){
//            arr6[i]=(int)(Math.random()*50);}
        System.out.println(Arrays.toString(arr6));
        System.out.println(nomSix(arr6) + "\n");

        // Генерация массива, случайных чисел, удовлетворяющих условию задачи 6

        int[] arrx = new int[9];
        for (; ; ) {
            for (int i = 0; i < arrx.length; i++) {
                arrx[i] = (int) (Math.random() * 50);
            }
            if (nomSix(arrx)) {
                break;
            }
        }
        System.out.println(Arrays.toString(arrx));
        System.out.println(nomSix(arrx) + "\n");


        //7 **** Написать метод, которому на вход подаётся одномерный массив и число n (может бытьположительным,
        // или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи
        // нельзя пользоваться вспомогательными массивами.

        int[] arr7 = new int[8];
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = (int) (Math.random() * 50);
        }
        System.out.println(Arrays.toString(arr7));
        System.out.println(Arrays.toString(round(arr7, 2)));

    }

    public static boolean nomSix(int[] arr) {
        if (arr.length % 2 == 0) {
            int summ1 = 0;
            int summ2 = 0;
            int i = 0;
            for (; i < arr.length / 2; i++) {
                summ1 += arr[i];
            }
            for (; i < arr.length; i++) {
                summ2 += arr[i];
            }
            return summ1 == summ2;
        } else {
            int summ1 = 0;
            int summ2 = 0;
            int i = 0;
            for (; i < arr.length / 2; i++) {
                summ1 += arr[i];
            }
            int summ3 = arr[i];
            i++;
            for (; i < arr.length; i++) {
                summ2 += arr[i];
            }
            return summ1 + summ3 == summ2 || summ1 == summ2 + summ3;
        }

    }

    public static int[] round(int[] arr, int n) {
        for (; ; ) {
            if (n != 0) {
                if (n < 0) {
                    int step = arr[0];
                    for (int i = 0; i < arr.length - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    arr[arr.length - 1] = step;
                    n++;
                } else {
                    int step = arr[arr.length - 1];
                    for (int i = arr.length - 1; i > 0; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[0] = step;
                    n--;
                }
            } else {
                return arr;
            }
        }
    }
}