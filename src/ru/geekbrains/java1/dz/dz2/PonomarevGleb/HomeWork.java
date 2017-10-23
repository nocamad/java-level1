package ru.geekbrains.java1.dz.dz2.PonomarevGleb;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        int[] reverseArray = {0, 1, 0, 0, 0, 1, 1}; // создаем массив для решения задачи №1
        reverseMassive(reverseArray); // вызов метода для решения задачи №1
        int[] emptyArray = new int[8]; // создаем пустой массив для задачи №2
        fillArray(emptyArray); //вызов метода для решения задачи №2
        int[] numsArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // создаем массив для задачи №3
        searchLessThanSix(numsArray); // вызов метода для задачи №3
        int[][] tableArray = new int[5][5]; // создаем двумерный массив для задачи №5
        drawMatrix(tableArray); // вызов метода для задачи №4
        int[] minMaxArray = {0, 12, 2, -5, 28, 7, 46, 4}; // создаем массив для задачи №5
        searchMinMax(minMaxArray); // вызов метода для задачи №5
        int[] sumArray = {2, 3, 4, 1, 8}; // создаем массив для задачи №6
        System.out.println(checkSumArray(sumArray) + " - результат задачи №6"); // вызов метода для задачи №6
        int[] routeArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // массив для задачи №7
        arrayRoute(routeArray, 2); //вызов метода для задачи №7
    }

    public static void reverseMassive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    nums[i] = 1;
                    break;
                default:
                    nums[i] = 0;
            }
        }

        System.out.println(Arrays.toString(nums) + " - результат задачи №1");
    }

    public static void fillArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 3;
        }

        System.out.println(Arrays.toString(nums) + " - результат задачи №2");
    }

    public static void searchLessThanSix(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }

        System.out.println(Arrays.toString(nums) + " - результат задачи №3");
    }

    public static void drawMatrix(int[][] nums) {
        System.out.println("Результат задачи №4");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][i] = 1;
                nums[i][nums.length - 1 - i] = 1;
                System.out.print(nums[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void searchMinMax(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Результат задачи №5: \n" + "Минимальное значеие массива: " + min + " " + "Максимальное значение массива: " + max);
    }

    public static boolean checkSumArray(int[] nums) {
        int sumArray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumArray += nums[i];
        }
        if (sumArray % 2 != 0) {
            return false;
        } else {
            int checkSum = 0;
            for (int i = 0; i < nums.length; i++) {
                checkSum += nums[i];
                if (checkSum == sumArray / 2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void arrayRoute(int[] nums, int count) {
        for (int i = 1; i <= Math.abs(count); i++) {
            if (count >= 0) {
                int previousEl = nums[0];
                int nextEl;
                for (int j = 1; j < nums.length; j++) {
                    nextEl = nums[j];
                    nums[j] = previousEl;
                    previousEl = nextEl;
                }
                nums[0] = previousEl;
            } else {
                int previousEl = nums[0];
                int nextEl;
                for (int j = nums.length - 1; j >= 0; j--) {
                    nextEl = nums[j];
                    nums[j] = previousEl;
                    previousEl = nextEl;
                }
            }
        }
        System.out.println(Arrays.toString(nums) + " - результат задачи №7");
    }

}
