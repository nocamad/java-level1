package ru.geekbrains.java1.lesson2;

import java.util.Arrays;

/**
 * Created by Home-pc on 21.07.2016.
 */
public class MassClass {
    public static void main(String[] args) {
        // Массивы
        int[] arr1 = new int[10]; // Создаем массив из 10 элементов
        arr1[0] = 10;
        int[] arr2 = {10, 2, 3, 478, 5}; // Создаем массив и сразу инициализируем значения
//        System.out.println(Arrays.toString(arr2)); // Простая распечатка массива в одну строку
//        for (int i = 0; i < arr2.length; i++) { // Распечатка массива в одну строку с пробелами вручную через цикл
//            System.out.print(arr2[i] + " "); // На каждой итерации печатаем значение ячейки массива и ставим пробел
//        }
//        for (int x : arr2) {
//            System.out.println(x);
//        }
//int j =1;
//        for (int i : arr2){
//            j++;
//            if (j == 4) continue;
//            System.out.print(i+ " ");
//        }
        int w = arr1.length; // arr1.length - длина массива arr1, в w запишется 10
        int[][] arr3 = new int[3][3]; // двумерный массив, размером 3х3
        int[][] arr4 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3, 7}}; // двумерный массив с инициалзиацией значений
//        System.out.println(Arrays.deepToString(arr4)); // Простая распечатка двумерного массива в одну строку
int a = arr4.length;
        int b1 = arr4[0].length;
        int b2 = arr4[1].length;
        int b3 = arr4[2].length;
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
