package ru.geekbrains.java1.dz.dz2.TerehovAleksei;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //проверка задания 1
        System.out.println("проверка задания 1:");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        reverseArray(arr1);
        System.out.println();

        //проверка задания 2
        System.out.println("проверка задания 2:");
        System.out.println(Arrays.toString(createArray()));
        System.out.println();

        //проверка задания 3
        System.out.println("проверка задания 3:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multiplyBy2(arr3)));
        System.out.println();

        //проверка задания 4
        System.out.println("проверка задания 4:");
        int[][] arr4 = new int[6][6];
        squareArray(arr4);
        System.out.println();

        //проверка задания 5
        System.out.println("проверка задания 5:");
        Random random = new Random();
        int[] arr5 = new int[10];
        for (int i = 0; i < arr5.length; i++){
            arr5[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr5));
        minAndMaxInArray(arr5);
        System.out.println();

        //проверка задания 6
        System.out.println("проверка задания 6:");
        int[] arr6 = {6, 3, 2, 1};
        System.out.println(checkBalance(arr6));
        System.out.println();

        System.out.println("Проверка задания 7:");
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrOffset = offsetArray(arr7, 67);
        System.out.println(Arrays.toString(arrOffset));
    }

    //задание 1(с помощью цикла и условия заменить 0 на 1, 1 на 0)
    private static void reverseArray(int[] arr) {
        //проверки на входные значения
        boolean isCorrect = true;
        if (arr.length == 0) {
            System.out.println("Некорреткная длинна массива");
            isCorrect = false;
        }

        for (int x : arr) {
            if (x != 0 && x != 1) {
                System.out.println("В массиве недопустимые значения");
                System.out.println("Разрешено использовать только 0 и 1");
                isCorrect = false;
                break;
            }
        }
        //рассчет
        if (isCorrect == true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    //задание 2 (Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21)
    private static int[] createArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3;
        }
        return arr;
    }

    //задание 3 (пройти по массиву циклом, и числа меньшие 6 умножить на 2)
    private static int[] multiplyBy2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
        return arr;
    }

    //задание 4 (Создать квадратный двумерный целочисленный массив и заполнить его диагональные элементы единицами)
    private static void squareArray(int[][] arr) {
        //проверка на квадратность
        if (arr.length != arr[0].length){
            System.out.println("массив не является квадратным");
        }
        else {
            //заполнение массива
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if ((i == j) || (i == arr.length - 1 - j))
                        arr[i][j] = 1;
                }
            }
            //вывод результата
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //задание 5 (Задать одномерный массив и найти в нем минимальный и максимальный элементы )
    private static void minAndMaxInArray(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("минимальный элемент: "+min);
        System.out.println("максимальный элемент: "+max);
    }

    //задание 6 (вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны)
    private static boolean checkBalance(int[] arr) {
        boolean isEquals = false;   //тут будем хранить результат и изначально предположим, что совпадений нет
        for (int i = 0; i < arr.length - 1; i++) {   //проходим по массиву и в каждой итерации суммируем элементы левой и правой частей не касаясь последнего элемента, т.к. это минимальная правая часть
            int sumLeft = 0;   //тут будем хранить суммы элементов левой части
            int sumRight = 0;   //а тут правой
            for (int j = 0; j < i + 1; j++) {   //суммируем все элементы до текущей позиции включая текущую позицию
                sumLeft += arr[j];
            }
            for (int k = i + 1; k < arr.length; k++) {  //суммируем все элементы, после текущей позиции
                sumRight += arr[k];
            }
            if (sumLeft == sumRight) //сравниваем и, если они равны, то меняем результат на true
                isEquals = true;
        }
        return isEquals;
    }

    //задание 7 (сместить все элементы массива на n позиций) смещение решено делать по кругу
    private static int[] offsetArray(int[] arr, int offset) {
        if (offset == 0)//если сдвиг равен нулю, то просто возвращаем массив
            return arr;
        else {
            //при смещении на число, равное длинне массива, мы получаем исходный массив
            //удалим ненужные операции
            if (Math.abs(offset) > arr.length)
                offset %= arr.length;
            //орицательное смещение можно преобразовать в положиельное, как длинна массива минус отрицательное смещение
            if (offset < 0)
                offset = arr.length - Math.abs(offset);
            //положительное смещение
            for (int i = 0; i < offset; i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 2; j > -1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[0] = temp;
            }
            return arr;
        }
    }
}
