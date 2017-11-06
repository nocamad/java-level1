package ru.geekbrains.java1.dz.dz4.KopeikinAleksey;

// попытка создания искуственнго интеллекта не совсем удалась, т.к. не хватило времени.
//За это прошу прощения
//        в целом, проерка выигрыша и ходов машины на циклах и массивах получилась

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static int size = 3;
    public static int victory = size;
    public static int[][] fild = new int[size][size];
    public static boolean endGame = false;

    public static void main(String[] args) {
//        int size = 3;
//        int[][] fild=new int[size][size];
        Scanner sc = new Scanner(System.in);
//        int i; int c=0;
//        for(i = 0; i<size;i++){
//            for (int j=0;j<size;j++){
//                if(fild[i][j]!="X"||fild[i][j]!="0"){
//                    fild[i][j]="*";
//                    c++;
//                }
//                System.out.print(fild[i][j]);
//                System.out.print(" ");
//
//            }
//            System.out.println();
//        }
        int ii = 0;
        while (score(size, fild) && ii < size * size) {

            //if(!score(size,fild)){break;}
            System.out.print("Введите кординаты вашего хода X=");
            int x = Integer.parseInt(sc.nextLine());
            for (; x > size; ) {
                System.out.println("такой клетки нет!");
                System.out.print("Введите кординаты вашего хода X=");
                x = Integer.parseInt(sc.nextLine());

            }
            System.out.print("Введите кординаты вашего хода Y=");
            int y = Integer.parseInt(sc.nextLine());
            for (; y > size; ) {
                System.out.println("такой клетки нет!");
                System.out.print("Введите кординаты вашего хода Y=");
                y = Integer.parseInt(sc.nextLine());

            }

            if (fild[x][y] == 0) {
                fild[x][y] = 1;
            } else {
                System.out.println("эта клетка уже занята, попробуйте другую");
            }

            //System.out.println(fild[x][y]);
            ii++;
            victoryCheck();
            mashineScore();
            victoryCheck();
            if (endGame) {
                visiblel();
                return;
            }

        }


    }
//    public static char userStep(){
//
//
//    }

//    public static void userStep(){
//
//        for(i = 0; i<size;i++){
//            for (int j=0;j<size;j++){
//                if(fild[i][j]!="X"||fild[i][j]!="0"){
//                    fild[i][j]="*";
//                    c++;
//                }
//                System.out.print(fild[i][j]);
//                System.out.print(" ");
//
//            }
//            System.out.println();
//        }


    //   }

    public static boolean score(int size, int[][] fild) {

        int i;
        int c = 0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //if(fild[i][j]==""){
                switch (fild[i][j]) {

                    case 1:
                        System.out.print("X");
                        System.out.print(" ");
                        break;
                    case 2:
                        System.out.print("0");
                        System.out.print(" ");
                        break;
                    default:
                        System.out.print("*");
                        System.out.print(" ");
                        c++;
                        break;

                }
                //  if(fild[i][j]!="X"||fild[i][j]!="0"){
                //fild[i][j]="*";

            }
            //System.out.print(fild[i][j]);
            System.out.println(" ");

        }
        System.out.println();

        System.out.println(c);
        if (c == 0) {
            return false;
        }
        return true;
    }

    public static void mashineScore() {
        int x = size;
        int y = size;
        int z = size * size;
        int v = 0;
        int us = 0;
        int comp = 0;
        x = x / 2;
        y = y / 2;
        if (fild[x][y] == 0) {
            fild[x][y] = 2;
            return;
        }
        int[] freeCells = new int[z];
        for (int i = 0; i < size; i++) {
            us = 0;
            comp = 0;
            for (int j = 0; j < size; j++) {

                if (fild[j][i] == 1) {
                    us = us + 1;
                } else {
                    us = 0;
                }
                if (fild[j][i] == 1) {
                    comp = comp + 1;
                } else {
                    comp = 0;
                }
                if (us > 1 && fild[j][i] == 0) {
                    fild[j][i] = 2;
                    return;
                }

            }
        }
        int vvcommm = 0;
        int jj = 0;
        int ii = 0;
        for (int i = 0; i < size; i++) {

            if (fild[size - 1 - i][i] == 2) {
                vvcommm = vvcommm + 1;
            }
            if (fild[size - 1 - i][i] == 0) {
                jj = size - 1 - i;
                ii = i;
            }

            // if()
            if (vvcommm + 1 == victory) {
                fild[jj][ii] = 2;
                return;
            }

        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//
                if (fild[i][j] == 1) {
                    us = us + 1;
                }
                if (fild[i][j] == 2) {
                    comp = comp + 1;
                }
                if (fild[i][j] == 0) {
                    fild[i][j] = 2;
                    return;
                }
                System.out.print("Координаты:" + fild[i][j] + "_" + j + "_" + i);
            }
            if (comp == 2) {
            }
        }
        for (int i = 0; i < z; i++) {
            System.out.print(freeCells[i] + " ");
            System.out.println();
        }
        int vicom = 0;
        jj = 0;
        ii = 0;
        for (int i = 0; i < size; i++) { //проверка горизонталей
            for (int j = 0; j < size; j++) {
                if (fild[i][j] == 2) {
                    vicom = vicom + 1;
                }
                if (fild[i][j] == 0) {
                    jj = j;
                    ii = i;
                }

                if (vicom + 1 == victory) {
                    fild[ii][jj] = 2;
                    return;
                }
                System.out.print("Координаты:" + fild[i][j] + "_" + j + "_" + i);
            }


        }
        vicom = 0;
        jj = 0;
        ii = 0;
        for (int i = 0; i < size; i++) { //Проверка вертикалей
            for (int j = 0; j < size; j++) {
                if (fild[j][i] == 2) {
                    vicom = vicom + 1;
                }
                if (fild[j][i] == 0) {
                    jj = j;
                    ii = i;
                }

                if (vicom + 1 == victory) {
                    fild[jj][ii] = 2;
                    return;
                }
                System.out.print("Координаты:" + fild[j][i] + "_" + j + "_" + i);
            }


        }
        // System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
    }


    public static void victoryCheck() {
        int vius = 0;
        int vicom = 0; //Проверка прямой диагонали
        for (int i = 0; i < size; i++) {
            if (fild[i][i] == 2) {
                vicom = vicom + 1;
            }
            if (fild[i][i] == 1) {
                vius = vius + 1;
            }
            if (vicom == victory || vius == victory) {
                break;
            }

        }
        int i = 0;
        int j = size - 1;
        vicom = 0;
        vius = 0;
        int jj = 0;
        int ii = 0;
        while (i < size && j >= 0) {
            //int jj;int ii;
            if (fild[j][i] == 2) {
                vicom = vicom + 1;
            }
            if (fild[j][i] == 1) {
                vius = vius + 1;
            } //Проверка обратной диагонали
            if (fild[j][i] == 0) {
                jj = j;
                ii = i;
            }
            //   System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
            if (vicom == victory || vius == victory) {
                break;
            }
            //  System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
            System.out.println();
//            if(vicom+1==victory){                fild[jj][ii] = 2;
//vicom=victory;
//            }

            i++;
            j--;

        }
        i = 0;
        j = 0;
        vicom = 0;
        vius = 0;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (fild[j][i] == 2) {
                    vicom = vicom + 1;
                }
                if (fild[j][i] == 1) {
                    vius = vius + 1;
                } //Проверка обратной диагонали
                if (fild[j][i] == 0) {
                    jj = j;
                    ii = i;
                }
                //   System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
                if (vicom == victory || vius == victory) {
                    break;
                }
                //  System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
                System.out.println();
            }

        }
        i = 0;
        j = 0;
        vicom = 0;
        vius = 0;
        for (j = 0; j < size; j++) {
            for (i = 0; i < size; i++) {
                if (fild[j][i] == 2) {
                    vicom = vicom + 1;
                }
                if (fild[j][i] == 1) {
                    vius = vius + 1;
                } //Проверка обратной диагонали
                if (fild[j][i] == 0) {
                    jj = j;
                    ii = i;
                }
                //   System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
                if (vicom == victory || vius == victory) {
                    break;
                }
                //  System.out.print("Координаты:"+fild[i][j]+"_"+j+"_"+i);
                System.out.println();
            }

        }


//        for (int i=0,int j=size-1;i<size;j--){
//           // int j=size-1;
//            if(fild[j][i]==2){vicom=vicom+1;}
//            if(fild[j][i]==1){vius=vius+1;}
//            if(vicom==victory||vius==victory){break;}
//            System.out.print(fild[i][j]+"_"+j+"_"+i);
//            System.out.println();
//
//        }

        if (vicom == victory) {
            System.out.println("Выиграл компьютер!");
            endGame = true;
        }
        if (vius == victory) {
            System.out.println("Выиграл пользователь!" + victory);

            endGame = true;

        }
    }

    public static void visiblel() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //if(fild[i][j]==""){
                switch (fild[i][j]) {

                    case 1:
                        System.out.print("X");
                        System.out.print(" ");
                        break;
                    case 2:
                        System.out.print("0");
                        System.out.print(" ");
                        break;
                    default:
                        System.out.print("*");
                        System.out.print(" ");
                        // c++;
                        break;

                }


            }
            System.out.println();
        }
    }


}