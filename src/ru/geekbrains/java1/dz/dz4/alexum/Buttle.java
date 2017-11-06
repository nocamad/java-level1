package ru.geekbrains.java1.dz.dz4.alexum;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alecum on 26.10.2017.
 */
public class Buttle {

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static class ButtleField {
        private static final int DOTS_TO_WIN = 4;
        public static char[][] field;
        public static final int SIZE = 5;

        public void setX(int x, int y) {
            field[x][y] = DOT_X;
        }

        public void setO(int x, int y) {
            field[x][y] = DOT_O;
        }

        public void initMe() {
            field = new char[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    field[i][j] = DOT_EMPTY;
                }
            }
        }

        public void printMe() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public boolean isFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (field[i][j] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean isCellValid(int x, int y) {
            if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
                return false;
            }
            return field[x][y] == DOT_EMPTY;
        }

        public boolean checkWin(char dot) {
            for (int i = 0; i < SIZE; i++) {
                int iWin = 0;
                int jWin = 0;
                int mainDiagWin = 0;
                int secondDiagWin = 0;
                for (int j = 0; j < SIZE; j++) {
                    iWin = field[i][j] == dot ? iWin + 1 : 0;
                    jWin = field[j][i] == dot ? jWin + 1 : 0;
                    if (iWin == DOTS_TO_WIN || jWin == DOTS_TO_WIN) {
                        return true;
                    }

                    mainDiagWin = field[j][j] == dot ? mainDiagWin + 1 : 0;
                    secondDiagWin = field[j][SIZE - (j + 1)] == dot ? secondDiagWin + 1 : 0;
                    if (mainDiagWin == DOTS_TO_WIN || secondDiagWin == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class ButtleController {

        private Scanner scanner = new Scanner(System.in);

        public void manageButtle(ButtleField field) {
            while (true) {
                humanTurn(field);
                field.printMe();
                if (field.checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (field.isFull()) {
                    System.out.println("Ничья");
                    break;
                }

                aiTurn(field);
                field.printMe();
                if (field.checkWin(DOT_O)) {
                    System.out.println("Слава роботам!");
                    break;
                }
                if (field.isFull()) {
                    System.out.println("Ничья");
                    break;
                }

            }
            System.out.println("Game over!");
        }

        private void aiTurn(ButtleField field) {
            int x, y;
            Random rand = new Random();
            do {
                x = rand.nextInt(ButtleField.SIZE);
                y = rand.nextInt(ButtleField.SIZE);
            } while (!ButtleField.isCellValid(x, y));
            System.out.println("AI went to [" + x + ", " + y + "]");

            field.setO(x, y);
        }

        private void humanTurn(ButtleField field) {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!ButtleField.isCellValid(x, y));
            field.setX(x, y);
        }
    }


    public static void main(String[] args) {
        ButtleField buttlefield = new ButtleField();
        buttlefield.initMe();
        buttlefield.printMe();
        ButtleController referee = new ButtleController();

        referee.manageButtle(buttlefield);

    }


}
