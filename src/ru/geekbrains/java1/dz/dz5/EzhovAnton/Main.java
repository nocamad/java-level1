package ru.geekbrains.java1.dz.dz5.EzhovAnton;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Personnel[] persArray = new Personnel[5];
        persArray[0] = new Personnel("Wiktor Wojtas", "Engineer", "taz@gmail.com", "7543576343", 30050, 35);
        persArray[1] = new Personnel("Filip Kubski", "Race driver", "neo@yahoo.com", "4324325451234", 40000, 65);
        persArray[2] = new Personnel("Jaroslaw Jarzabkowski", "Marketing director", "paszabiceps@hotmail.com", "4345333345l", 25000, 30);
        persArray[3] = new Personnel("Janusz Pogorelski", "Car mechanic", "snax@list.com", "843274555643l", 35000, 41);
        persArray[4] = new Personnel("Pawel Bielinski", "Cybersportsman", "byali@gmail.com", "333245423345l", 29000, 50);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printInfo();
                System.out.println();
            }
        }
    }
}
