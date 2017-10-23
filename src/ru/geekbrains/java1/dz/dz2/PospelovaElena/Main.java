package ru.geekbrains.java1.dz.dz2.PospelovaElena;


import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


      /*  System.out.println("Task 1");
        task1();
        System.out.println("------------------");
        System.out.println();

        System.out.println("Task 2");
        task2();
        System.out.println("------------------");
        System.out.println();

        System.out.println("Task 3");
        task3();
        System.out.println("------------------");
        System.out.println();*/

        System.out.println("Task 4");
        task4(5);
        System.out.println("------------------");
        System.out.println();

        System.out.println("Task 5");
        maxMin(25);
        System.out.println("------------------");
        System.out.println();

        System.out.println("Task 6");
        int[] arr = {2, 2, 3, 4, 1, 2, 2};
        System.out.println(checkBalance(arr));
        System.out.println("------------------");
        System.out.println();

        System.out.println("Task 7");
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        valuesShift(arr1, -2);
        System.out.println("------------------");
        System.out.println();
    }

    private static void task1() {

        int[] binArr = new int[10];
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 2);
            binArr[i] = a;
        }
        System.out.println(Arrays.toString(binArr));

        for (int i = 0; i < binArr.length; i++) {
            if (binArr[i] == 0) {
                binArr[i] = 1;
            } else {
                binArr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(binArr));
    }

    private static void task2() {
        int[] arr = new int[8];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
            a += 3;
        }
        System.out.println(Arrays.toString(arr));

    }

    private static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 6, 54, 1, 78, 44, 0, 4, 33};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void task4(int a) {
        int[][] arr = new int[a][a];
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            arr[i][j] = 1;
        }

        for (int[] i: arr)  {
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }

    private static void maxMin(int b) {
        int[] arr = new int[b];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int max = 0, min = 100;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max = " + max + " Min = " + min);
    }

    private static boolean checkBalance(int[] array) {
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += array[j];
            }
            for (int f = array.length - 1; f >= i; f--) {
                sum2 += array[f];
            }
            if (sum1 == sum2) {
                System.out.println("sum1 = " + sum1 + "  sum2 = " + sum2);
                check = 1;
                break;
            }
        }
        return check == 1;
    }

    private static void valuesShift(int[] array, int n) {
        System.out.println(Arrays.toString(array));
        System.out.println("shift to "+n);

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int en = array[array.length - 1];
                for (int j = 1; j < array.length; j++) {
                    array[array.length - j] = array[array.length - j - 1];
                }
                array[0] = en;
            }
        } else if (n < 0) {
            for (int i = 0; i > n; n++) {
                int en = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = en;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}

