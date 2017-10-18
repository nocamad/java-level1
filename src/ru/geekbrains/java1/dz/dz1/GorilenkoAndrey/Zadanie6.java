package ru.geekbrains.java1.dz.dz1.GorilenkoAndrey;

public class Zadanie6 {
    public static void main(String[] args) {
int a=-1;

    boolean c=getSravnenie(a);
    System.out.println(c);
    }
public static boolean getSravnenie(int a){
        boolean b;
        if (a>=0) {
            b=false;
        }
else {
            b=true;
        }
    return b;
    }

}
