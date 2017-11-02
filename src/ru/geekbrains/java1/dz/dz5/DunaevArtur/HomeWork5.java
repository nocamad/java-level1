package ru.geekbrains.java1.dz.dz5.DunaevArtur;

public class HomeWork5 {

    public static void main(String[] args) {

        // * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
        // * Конструктор класса должен заполнять эти поля при создании объекта;
        Person personSingle = new Person("Иванов Иван",
                "Бухгалтер",
                "iivanov@mail.ru",
                "89161234567",
                50000,
                40);

        // * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        personSingle.printPersonCard();

        // * Создать массив из 5 сотрудников
        Person[] persons = new Person[5];
        persons[0] = new Person("Петров Петр", "Программист", "prog@mail.ru",
                "89161234561", 60000, 30);
        persons[1] = new Person("Сидоров Иван", "Инженер", "inzh@mail.ru",
                "89161234562", 40000, 50);
        persons[2] = new Person("Краснов Степан", "Консультант", "kons@mail.ru",
                "89161234563", 55000, 35);
        persons[3] = new Person("Белов Александр", "Аналитик", "analit@mail.ru",
                "89161234564", 45000, 41);
        persons[4] = new Person("Иванов Сергей", "Дизайнер", "dizain@mail.ru",
                "89161234565", 30000, 25);

        // * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println();
        System.out.println("Сотрудники старше 40 лет:");
        System.out.println("-----");
        for (Person person : persons) {
            if (person.getAge() >= 40) {
                person.printSmallPersonCard();
            }
        }

    }

}
