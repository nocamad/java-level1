package ru.geekbrains.java1.dz.dz5.RuslanGafurov;

public class Main {


    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Сергей Петрович", "Курьер", "ivanov.sp@mycomp.com", "786659388444", 35000, 22);
        persArray[1] = new Person("Смирнова Алиса Сергеевна", "Бухгалтер", "smirnova.as@mycomp.com", "795543946742", 44000, 35);
        persArray[2] = new Person("Зуев Вячеслав Анатольевич", "Старший Менеджер", "zuev.va@mycomp.com", "795743362474", 68000, 46);
        persArray[3] = new Person("Молотов Юрий Александрович", "Менеджер", "molotov.ua@mycomp.com", "795565326875", 61000, 42);
        persArray[4] = new Person("Парамонов Степан Юрьевич", "Директор", "king@mycomp.com", "793294735635", 89000, 57);
        int i=0;
        System.out.println("Список сотрудников старше 40 лет:");
        for(Person person:persArray){
            if(person.getAge()>=40){
                System.out.println("\nСотрудник №"+(++i));
                person.printInfo();
            }
        }
    }
}
