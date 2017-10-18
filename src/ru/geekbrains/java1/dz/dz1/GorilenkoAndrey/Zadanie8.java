package ru.geekbrains.java1.dz.dz1.GorilenkoAndrey;

public class Zadanie8 {
    public static void main(String[] args) {
        int a=2040;
String c=getVisokos(a);
    System.out.println(c);

    }
public static String getVisokos(int a){
        String b;
        if (a%400==0 || (a%4==0 && a%100!=0)){
b="Год високосный";
        }
else {
           b= "Год невисокосный";
        }
    return b;
    }


}
