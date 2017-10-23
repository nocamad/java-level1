package ru.geekbrains.java1.dz.dz2.EmelyanovSergey;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Dz2 {
    public static void main(String[] args) {

        ////////////////////////////////////
        // п.1  ////////////////////////////
        ////////////////////////////////////

        if (true) { //кодовый блок для ограничения видимоcти переменных
            System.out.println(" =========== п.1 ===========");

            int[] arrInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.println("Старые значения " + Arrays.toString(arrInt));
            //ЗАМЕНА
            for (int i = 0; i < arrInt.length; i++) {
                arrInt[i] = (arrInt[i] == 1) ? 0 : 1;
            }
            System.out.println("Новые_ значения " + Arrays.toString(arrInt));
        }

        ////////////////////////////////////
        // п.2  ////////////////////////////
        ////////////////////////////////////
        if (true) { //кодовый блок для ограничения видимоcти переменных
            System.out.println(" =========== п.2 ===========");
            //int[] arrInt = new int[8];
            int arrInt[] = new int[8];
            for (int i = 0; i < arrInt.length; i++) {
                arrInt[i] = i * 3;
            }
            System.out.println("Значения " + Arrays.toString(arrInt));
        }

        ////////////////////////////////////
        // п.3  ////////////////////////////
        ////////////////////////////////////
        exec_p3_ChangeArray();

        ////////////////////////////////////
        // п.4  ////////////////////////////
        ////////////////////////////////////
        exec_p4_Create2DimensionalArray();

        ////////////////////////////////////
        // п.5 ////////////////////////////
        ////////////////////////////////////
        exec_p5_FindMinMaxElements();

        ////////////////////////////////////
        // п.6 ////////////////////////////
        ////////////////////////////////////
        System.out.println(" =========== п.6 ===========");
        if (true) { //кодовый блок для ограничения видимоcти переменных
            int[] arrInt = {1, 5, 5, 4}; //нет баланса
            System.out.print("Массив " + Arrays.toString(arrInt));
            System.out.println(" Баланс - " + exec_p6_CheckBalance(arrInt));
        }
        if (true) { //кодовый блок для ограничения видимоcти переменных
            int[] arrInt = {2, 2, 5, 5, 1, 3}; //2+2+5 == 5+1+3 == 9
            System.out.print("Массив " + Arrays.toString(arrInt));
            System.out.println(" Баланс - " + exec_p6_CheckBalance(arrInt) + " [2+2+5 == 5+1+3] ");
        }
        if (true) { //кодовый блок для ограничения видимоcти переменных
            int[] arrInt = {2, 2, 5, 5, 20, -6}; //2+2+5+5 == 20+ -6 == 14
            System.out.print("Массив " + Arrays.toString(arrInt));
            System.out.println(" Баланс - " + exec_p6_CheckBalance(arrInt) + " [2+2+5+5 == 20+ -6] ");
        }

        ////////////////////////////////////
        // п.7 ////////////////////////////
        ////////////////////////////////////
        System.out.println(" =========== п.7 ===========");
        if (true) { //кодовый блок для ограничения видимоcти переменных
            int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            System.out.println("исх== " + Arrays.toString(arrInt));
            System.out.println("рез+2 " + Arrays.toString(exec_p7_MoveArray(arrInt, 2)));
            System.out.println("рез-4 " + Arrays.toString(exec_p7_MoveArray(arrInt, -4)));
            System.out.println("рез+2 " + Arrays.toString(exec_p7_MoveArray(arrInt, 2)));
        }

        System.out.println(" ===========================");

    }

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
// МЕТОДЫ
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

    private static void exec_p3_ChangeArray() {
        System.out.println(" =========== п.3 ===========");

        int arrInt[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Старые значения " + Arrays.toString(arrInt));
        int counter=0;
        for (int elemValue : arrInt)  {
            if (elemValue < 6) {
                arrInt[counter] *= 2;
            }
            counter++;
        }
        System.out.println("Новые_ значения " + Arrays.toString(arrInt));
    }

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

    private static void exec_p4_Create2DimensionalArray() {
        System.out.println(" =========== п.4 ===========");

        int[][] arrInt = new int[8][8];
        for (int i = 0, j=0, k=arrInt.length-1; i < arrInt.length; i++,j++,k--) {
                arrInt[i][j] = 1;
                arrInt[i][k] = 1;
            }

        //Arrays.deepToString() в данном случае не показательно
        for (int i = 0; i < arrInt.length; i++)
            System.out.println("Двумерный массив [i=" + i + "] " + Arrays.toString(arrInt[i]));
    }

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

    private static void exec_p5_FindMinMaxElements() {
        System.out.println(" =========== п.5 ===========");
        int arrInt[] = new int[20];

        //заполняем случайными числами
        for (int i=0;i<arrInt.length;i++) {
            int Neg = ((int) (Math.random() * 2) == 1 ? 1 : -1); //определяем знак + или -
            arrInt[i] = (int) (Math.random() * 1000 * Neg);
        }

        //поиск значений. присваиваем arrInt[0], чтобы гарантировать, что значения
        //maxVal и minVal из массива (не ноль, нуля может и не быть в масиве)
        int maxVal = arrInt[0];
        int minVal = arrInt[0];

        for (int arrElemValue : arrInt) {
            if (maxVal < arrElemValue) maxVal = arrElemValue;
            if (minVal > arrElemValue) minVal = arrElemValue;
        }

        System.out.println("Массив " + Arrays.toString(arrInt));
        System.out.println("Min=" + minVal);
        System.out.println("Max=" + maxVal);
    }

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

    private static boolean exec_p6_CheckBalance(int[] inArr) {
        if (inArr.length < 2) {
            return false;
        }
        int leftSumm = 0;
        int rightSumm = 0;
        boolean haveBalance = false;
        for (int i = 0; i < inArr.length - 1; i++) {
            leftSumm += inArr[i];
            rightSumm = 0;
            for (int j = i + 1; j < inArr.length; j++) {
                rightSumm = rightSumm + inArr[j];
            }
            if (leftSumm == rightSumm) {
                haveBalance = true;
                break;
            }
        }
        return haveBalance;
    }

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

    private static int[] exec_p7_MoveArray(int[] inArr, int inPositionMove) {
        while (inPositionMove != 0) {
            if (inPositionMove > 0) {
                for (int i = inArr.length - 1; i > 0; i--) {
                    inArr[i] = inArr[i - 1];
                }
                inArr[0] = 0;
                inPositionMove--;
            }
            if (inPositionMove < 0) {
                for (int i = 0; i < inArr.length - 1; i++) {
                    inArr[i] = inArr[i + 1];
                }

                inArr[inArr.length - 1] = 0;
                inPositionMove++;
            }
        }
        return inArr;
    }

}
