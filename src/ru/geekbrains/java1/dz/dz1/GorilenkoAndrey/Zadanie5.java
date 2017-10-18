package ru.geekbrains.java1.dz.dz1.GorilenkoAndrey;

public class Zadanie5 {
    public static void main(String[] args) {
        int b=-1;
String d=getSravnenie(b);
   System.out.println(d);
    }
public static String getSravnenie(int a){
        String c;
        if (a>=0){
            c="Число положительное";
        }
else {
            c="Число отрицательное";
        }
    return c;

    }

}

