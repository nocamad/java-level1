package ru.geekbrains.java1.dz.dz5.beloborodovdv;

public class Main {
    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("Иванов Иван Иванович", "клерк", "ivanovi@gmail.com", "911", 12000, 30);
        persons[1] = new Person("Иванов Семен Иванович", "водитель", "ivanovs@gmail.com", "912", 13000, 81);
        persons[2] = new Person("Иванов Вадим Иванович", "продавец", "ivanovv@gmail.com", "913", 14000, 32);
        persons[3] = new Person("Иванов Игнатий Иванович", "дворник", "ivanobv@gmail.com", "914", 15000, 83);
        persons[4] = new Person("Иванов ГЕоргий Иванович", "пастух", "ivanovg@gmail.com", "915", 16000, 34);


        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() > 39) {
                persons[i].printInfo();

            }
        }

        for (Person person : persons) {
            if (person.getAge() > 39) {
                person.printInfo();
            }
        }
    }

}
