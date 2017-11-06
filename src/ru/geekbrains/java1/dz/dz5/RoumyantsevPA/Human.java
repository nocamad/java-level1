package ru.geekbrains.java1.dz.dz5.RoumyantsevPA;

import java.util.Random;

public class Human {
    private String name;
    private String fName;
    private String oName;
    private String job;
    private String email;
    private String tel;
    private int age;
    private String gender;
    private int paycheck;
    public static int mansCount = 0;
    public static Random rand = new Random();
    String[] namesM = {"Назар", "Станислав", "Валентин", "Олег", "Поликарп", "Тимур", "Виктор"};
    String[] nameF = {"Эмма", "Фаина", "Эмилия", "Елизавета", "Анфиса", "Оксана", "Лолита"};
    String[] fNameR = {"Ермолаев", "Гаврилов", "Васильев", "Поляков", "Балашов", "Лаврентьев", "Егоров", "Казанцев", "Ермаков", "Базаров", "Евсеев", "Боголюбов", "Авдеев"};
    String[] mailF = {"Norned", "Mady", "Obsed", "Shrebadegge", "Maiduc", "Lumen", "Prolf", "Poper", "Exciou", "Dited", "Appee", "Rits"};
    String[] mailS = {"teleworm.us", "armyspy.com", "rhyta.com", "jourrapide.com", "gmail.com", "yandex.ru", "mail.ru"};
    String[] jobR = {"Портье", "Электронщик", "Оператор печи", "Консультант по психическому здоровью", "Челюстно-лицевой радиолог", "Биржевой брокер", "Социальный работник служб защиты детей", "Казначей", "Телефонистк", "Астроном", "Учитель"};

    public Human() {
        if (rand.nextInt(2) == 1) {
            this.gender = "М";
            this.name = namesM[rand.nextInt(namesM.length)];
            this.fName = fNameR[rand.nextInt(fNameR.length)];
            this.oName = namesM[rand.nextInt(namesM.length)] + "ович";


        } else {
            this.gender = "Ж";
            this.name=nameF[rand.nextInt(nameF.length)];
            this.fName=fNameR[rand.nextInt(fNameR.length)]+"а";
            this.oName = namesM[rand.nextInt(namesM.length)] + "овна";
        }
        this.job = jobR[rand.nextInt(jobR.length)];
        this.email = mailF[rand.nextInt(mailF.length)] + "@" + mailS[rand.nextInt(mailS.length)];
        this.tel = "+7 " + rnd() + rnd() + rnd() + " " + rnd() + rnd() + rnd() + "-" + rnd() + rnd() + "-" + rnd() + rnd();
        this.age = rand.nextInt(47)+18;
        this.paycheck=30000+rand.nextInt(30000);
        mansCount++;


    }

    public static int rnd() {
        return rand.nextInt(10);
    }

    public void printHuman(){
        System.out.println("ФИО:"+this.fName+" "+this.name+" "+this.oName);
        System.out.println("Возраст: "+this.age);
        System.out.println("Телефон/Почта: "+this.tel+"/"+this.email);
        System.out.println(this.job+". Зарплата: "+this.paycheck);
    }

    public boolean above40(){
        if (this.age>40){return true;}
        return false;
    }
}

