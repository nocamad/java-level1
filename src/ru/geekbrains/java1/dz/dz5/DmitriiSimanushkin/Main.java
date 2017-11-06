package ru.geekbrains.java1.dz.dz5.DmitriiSimanushkin;

public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Artem Sergeev", "Engineer", "artsergeev@mail.com", 891234567, 35000, 35);
        empArray[1] = new Employee("Katya Ivanova", "Developer", "kativanova@mail.com", 891231231, 50000, 43);
        empArray[2] = new Employee("Kirill Andreev", "Supervisor", "kirandreev@mail.com", 893213213, 41000, 40);
        empArray[3] = new Employee("Olga Kirilova", "Manager", "olgkirilova@mail.com", 894561237, 49000, 51);
        empArray[4] = new Employee("Sergey Ivanov", "Engineer", "serivanov@mail.com", 893515312, 29000, 24);

        for (int i = 0; i < 5; i++) {
            if (empArray[i].getAge() > 40) {
                empArray[i].employeeInfo();
            }
        }
    }
}