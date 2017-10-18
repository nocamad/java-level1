package ru.geekbrains.java1.dz.dz1.GorilenkoAndrey;

import java.net.SocketPermission;

public class Zadanie3 {
    public static void main(String[] args) {
        int a,b,c,d;
        a=b=c=d=10;
    int f=getVirag(a,b,c,d);
        System.out.println("Значение выражения="+f);
    }
public static int getVirag(int a, int b, int c, int d){
        int e=a*(b+(c/d));
        return e;
}

}

