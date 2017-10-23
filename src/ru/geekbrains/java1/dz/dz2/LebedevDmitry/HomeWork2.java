package ru.geekbrains.java1.dz.dz2.LebedevDmitry;

import java.util.Arrays;

public class HomeWork2 {
    // 1. Метод задает массив [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ] и заменяет в нем 0 на 1 и 1 на 0
    public static void task1() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    // 2.Метод задает массив, заполненый последовательностью 0 3 6 9 12 15 18 21
    public static void task2() {
        int[] array = new int[8];
        for (int i = 0, j = 0; i < array.length; i++, j += 3) {
            array[i] = j;
        }
//        array[0] = 0;
//        for (int i = 1; i < array.length; i++) {
//            array[i] = array[i-1] + 3;
//        }
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i * 3;
//        }
        System.out.println(Arrays.toString(array));
    }

    //3. Метод задает массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] и числа <6 умножает на 2
    public static void task3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    // 4. Метод создает квадратную матрицу указаного размера и
    // заполняет ее главную и побочную диагонали единицами
    public static int[][] squareMatrix(int size) {
        int[][] matrix = new int[size][size];
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            matrix[i][i] = 1;
            matrix[(length - 1) - i][i] = 1;
        }

        for (int[] array1 : matrix) {
            for (int array2 : array1) {
                System.out.print(array2 + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    // 5. Метод принимает на вход массив и выводит в консоль минимальный и максимальный элементы
    public static void maxAndMin(int[] array) {
        if (array.length == 0) {
            System.out.println("Пустой массив!");
            return;
        }
        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
//            max = Math.max(max, i);
//            min = Math.min(min, i);
        }
        System.out.println("Максимальное значение = " + max);
        System.out.println("Минимальное значение = " + min);
    }

    // 6. Метод возвращает true, если в передаваемом массиве есть место,
    // в котором сумма левой и правой части массива равны.
    public static boolean checkBalance(int[] array) {
        int length = array.length;
        if (length == 1) {
            System.out.println("Пустой массив!");
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            int sum1 = arraySum(0, i, array);                    //сумма левой части
            int sum2 = arraySum(i + 1, length - 1, array);  //сумма правой части
            if (sum1 == sum2) return true;
        }
        return false;
    }

    // Метод возвращает сумму элементов массива в пределах индексов [start, finish]
    private static int arraySum(int start, int finish, int[] array) {
        int sum = 0;
        for (int i = start; i <= finish; i++)
            sum += array[i];
        return sum;
    }

    //7. Метод смещает элементы переданного массива на указанное количество позиций по кругу
    public static void displacement(int[] array, int offset) {
        int length = array.length;
        if (length == 0) {
            System.out.println("Пустой массив!");
            return;
        }
        offset %= length;               // если смещение больше одного круга
        if (offset < 0) {               // привдение отрицательного смещения к положительному
            offset += length;
        }

        for (int i = 0; i < offset; i++) {
            int temp1 = array[0];
            for (int j = 1; j < length; j++) {
                int temp2 = temp1;
                temp1 = array[j];
                array[j] = temp2;
            }
            array[0] = temp1;
        }
    }

    public static void main(String[] args) {

        // 1.
        task1();
        System.out.println();
        // 2.
        task2();
        System.out.println();
        // 3.
        task3();
        System.out.println();
        // 4.
        squareMatrix(8);
        System.out.println();

        int[] array = {90, 3, 10, 7, 80, 30};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println();
        // 5.
        maxAndMin(array);
        System.out.println();
        // 6. 90+3+10+7 = 80+30
        System.out.println("Есть место, в котором правые и левые части равны: " + checkBalance(array));
        // 7.
        System.out.println();
        System.out.println("Смещение на (-2) позиции:");
        displacement(array, -2);
        System.out.println(Arrays.toString(array));
    }
}
