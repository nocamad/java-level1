package ru.geekbrains.java1.dz.dz5.TerehovAlexei;

public class Main {
    public static void main(String[] args) {
        Person persons[] = new Person[5];
        persons[0] = new Person("Иванов", "Менеджер", "vianov@mail.ru", "+375256453665",350, 28);
        persons[1] = new Person("Николаева", "Администратор","nikolaeva@mail.ru", "+375336748901", 420, 39);
        persons[2] = new Person("Жуков", "Охранник","zhukov@mail.ru", "+375294673844", 310, 46);
        persons[3] = new Person("Беляева", "Кассир","beliaeva@mail.ru", "+375294562765", 330, 41);
        persons[4] = new Person("Семёнов", "Грузчик","semenov@mail.ru", "+375251330019", 300, 37);

        Person.getOverAge(persons, 40);
    }
}
