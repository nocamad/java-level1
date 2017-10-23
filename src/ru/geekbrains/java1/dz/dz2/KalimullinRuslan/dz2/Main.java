package ru.geekbrains.java1.dz.dz2.KalimullinRuslan.dz2;

public class Main {
    public static int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1,
            0, 0};
    public static int[] arrayForMinMax = {3, 1, 7, 10, 6, 0, 89, 1987};

    public static void main(String[] args) {
        System.out.println("----------- Задание №1 -----------------------------");
        System.out.print("Входной массив -  ");
        showArrays(array1);

        System.out.print("\nВыходной массив - ");
        int[] array2 = replaceDatums(array1);
        showArrays(array2);

        System.out.println("\n----------- Задание №2 -----------------------------");
        showArrays(initArray());

        System.out.println("\n----------- Задание №3 -----------------------------");
        showArrays(changeArray());

        System.out.println("\n----------- Задание №4 -----------------------------");
        showArrays(fillDiagonal());

        System.out.println("\n----------- Задание №5 -----------------------------");
        showArrays(arrayForMinMax);
        System.out.println("\n" + getMinMaxForArray(arrayForMinMax));
    }

    public static void showArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void showArrays(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // Задание 1
    public static int[] replaceDatums(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }
        return array;
    }

    // Задание 2
    public static int[] initArray() {
        int[] array = new int[8];
        array[0] = 0;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + 3;
        }

        return array;
    }

    // Задание 3
    public static int[] changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
        return array;
    }

    // Задание 4
    public static int[][] fillDiagonal() {
        int[][] array = new int[6][6];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    array[i][j] = 1;
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }

    // Задание 5
    public static String getMinMaxForArray(int[] array){
        int min = array[0];
        int max = array[0];

        for(int i =0; i < array.length; i++){
            if(array[i] > max)
                max = array[i];
            else if(array[i] < min)
                min = array[i];
        }

        return "min = " + min + ", max = " + max;
    }
}
