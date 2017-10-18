package ru.geekbrains.java1.dz.dz1.GorilenkoAndrey;

import java.net.SocketPermission;

public class Zadanie4 {
    public static void main(String[] args) {
int a=10, b=16;
boolean e=getSum(a,b);
        System.out.println("Выражение "+e);

    }
public static boolean getSum(int a, int b){
        boolean d;
        if (a+b<=20 && a+b>=10) {
            d=true;
        }
else{
        d = false;
    }
    return d;
    }



}

