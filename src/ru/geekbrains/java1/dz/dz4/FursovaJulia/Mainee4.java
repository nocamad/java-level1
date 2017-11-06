package ru.geekbrains.java1.dz.dz4.FursovaJulia;
//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mainee4 {
        private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
        private static int size=5;
        private static int dots_to_win=4;
        public static final char dot_empty = '*';
        public static final char dot_x = 'X';
        public static final char dot_o = 'O';
        public static int[][]vesa=new int [size][size];
        public static int kH=2;
        private static char[][] map = new char[size][size]; // игровое поле
        private static Random rand = new Random(); // генератор случайных чисел

        public static void initMap() { // инициализируем массив map(игровое поле)
            for (int i = 0; i < size; i++) { // двойным циклом проходимся по всему массиву
                for (int j = 0; j < size; j++) {
                    map[i][j] = dot_empty; // и заполняем каждую ячейку *
                }
            }
        }
        //инициализация матрицы весов
        public static void initVes() {
            for (int i=0;i<size; i++) {
                for (int j=0; j<size; j++) {
                    vesa[i][j]=2;
                }
            }
            vesa[0][0]=vesa[size-1][0]=vesa[0][size-1]=vesa[size-1][size-1]=3;
            vesa[(size-1)/2][(size-1)/2]=4;
            /*for (int i = 0; i < size; i++) { // начинаем печатать поле
                for (int j = 0; j < size; j++) { // начинаем печатать строку
                    System.out.print(vesa[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
                }
                System.out.println(); // после распечатки строки, делаем перевод каретки
            }
            System.out.println(); // делаем дополнительный перевод строки*/
        }
        //вывод в консоль матрицы весов
    public static void printVes () {
    for (int i = 0; i < size; i++) { // начинаем печатать поле
        for (int j = 0; j < size; j++) { // начинаем печатать строку
            System.out.print(vesa[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
        }
        System.out.println(); // после распечатки строки, делаем перевод каретки
    }
    System.out.println(); // делаем дополнительный перевод строки
}
    // вывод поля
        public static void printMap() { // выводим игровое поле в консоль
            for (int i = 0; i <= size; i++) { // начинаем печатать поле
                System.out.print(i+" "); // первая строка с координатами
            }
            System.out.println();
            for (int i = 0; i < size; i++) { // начинаем печатать поле
                System.out.print((i + 1) + " "); // ставим номер строки 1-3
                for (int j = 0; j < size; j++) { // начинаем печатать строку
                    System.out.print(map[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
                }
                System.out.println(); // после распечатки строки, делаем перевод каретки
            }
            System.out.println(); // делаем дополнительный перевод строки
        }
// главный метод
        public static void main(String[] args) {
            initMap(); // инициализируем поле
            printMap(); // печатаем в консоль
            initVes();
            while (true) { // запускаем игровой цикл
                humanTurn(); // ход человека
                printMap(); // печать поля
                //printVes();
                if (isCheckWin(dot_x)) { // проверка победы человека
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break; // если поле заполнилось, завершаем игру
                }
                aiTurn(); // ход компьютера
                printMap(); // печать поля
                if (isCheckWin(dot_o)) { // проверка победы компьютера
                    System.out.println("Победил ИИ");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break; // если поле заполнилось, завершаем игру
                }
            }
            System.out.println("Game Over");
        }
    //проверка игровой линии
        public static boolean checkLine(int start_x, int start_y, int dx, int dy, char c) {
            for (int i = 0; i < dots_to_win; i++) {
                if (map[start_x + i * dx][start_y + i * dy] != c)
                    return false;
        }
        return true;
        }
//проверка победы
        public static boolean isCheckWin(char c) {
            for (int i = 0; i < size; i++) {
            if (checkLine(i, 0, 0, 1, c)) return true;
                if (checkLine(i, 1, 0, 1, c)) return true;
            if (checkLine(0, i, 1, 0, c)) return true;
                if (checkLine(1, i, 1, 0, c)) return true;
        }
            if (checkLine(0, 0, 1, 1, c)) return true;
            if (checkLine(0, size - 1, 1, -1, c)) return true;
            return false;
        }
//ход игрока
        private static void humanTurn() { // ход человека
            int x, y;
            do {
                System.out.println("Введите координаты в формате Х и У");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }
            while (!isCellEmpty(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку
            map[y][x] = dot_x; // после чего ставим туда Х
            vesa[y][x] = 0;
            for (int j = 0; j < size; j++) {
                vesa[y][j] = vesa[y][j]*kH;
            }
            //увеличение коэф-тов матрицы весов
            for (int i = 0; i < size; i++) {
                vesa[i][x] = vesa[i][x]*kH;
            }
            if (y==x) { int i=size-1;
                for (int j = 0; j < size; j++) {
                    vesa[j][j] = vesa[j][j]*kH;
                    vesa[i][j]=vesa[i][j]*kH;
                    i--;
                }
            }
        }
    //ход ИИ - в зависимости от коэффициентов матрицы весов
    private static void aiTurn() {
        int x = 0, y = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vesa[i][j] > max) {
                    max = vesa[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        map[x][y] = dot_o;
        //обнуляем коэф-т в ячейке, которая занята
        vesa[x][y]=0;
    }
    //проверка наполнения карты
        private static boolean isMapFull() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == dot_empty) return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
                }
            }
            return true;
        }
        //проверка ячейки
      public static boolean isCellEmpty(int x, int y) { // проверка является ли ячейка свободной
            if (x < 0 || x > (size-1) || y < 0 || y > (size-1)) return false; // если указаны неверные координаты, считаем что ячейка условно занята
            if (map[y][x] != dot_empty) return false; // если в ячейке не *, значит занята
            return true; // ячейка свободна
        }
    }