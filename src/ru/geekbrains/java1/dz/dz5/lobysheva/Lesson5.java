package ru.geekbrains.java1.dz.dz5.lobysheva;

/*
 * Created by Oxana Lobysheva on 28/10/2017.
 */

public class Lesson5 {

    private static Employer[] staff;

    public static void main(String[] args) {

        System.out.println("Найм:");

        staff = new Employer[5];
        staff[0] = new Employer("Сотрудник_000", "Император", "imperator@mail.ru", "-", 100000, 30);
        staff[1] = new Employer("Сотрудник_001", "Холоп", "slave001@mail.ru", "1-234-567-8991", 0.50f, 40);
        staff[2] = new Employer("Сотрудник_002", "Холоп", "slave002@mail.ru", "1-234-567-8992", 0.50f, 45);
        staff[3] = new Employer("Сотрудник_003", "Секретарь", "clerk@mail.ru", "911", 500.5f, 25);
        staff[4] = new Employer();

        getEmployerOlderThan(40);
    }

    private static void getEmployerOlderThan(int age){
        System.out.println("Сотрудники старше " + age + ":");
        for (int i = 0; i < staff.length; i++){
            if (staff[i].getAge() > age){
                staff[i].printPersonInfo();
            }
        }
    }
}
