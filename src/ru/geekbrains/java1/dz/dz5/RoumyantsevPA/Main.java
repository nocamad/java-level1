package ru.geekbrains.java1.dz.dz5.RoumyantsevPA;

public class Main {
    public static void main(String[] args) {
        Human[] humanArr=new Human[50];
        int count   =0;
        for (int i=0;i<humanArr.length;i++){
            humanArr[i]= new Human();
            if (humanArr[i].above40()&&count<10){
                humanArr[i].printHuman();
                System.out.println();
                count++;
            }
        }


    }
}
