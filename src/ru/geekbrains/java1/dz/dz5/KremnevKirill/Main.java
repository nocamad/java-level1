package ru.geekbrains.java1.dz.dz5.KremnevKirill;

public class Main {

    public static void main(String args[]){
        Employee[] emArray = new Employee[5];
        emArray[0] = new Employee("Stepanov Fedor", "driver", "drv@post.com", 92623412, 45000, 32);
        emArray[1] = new Employee("Krasavceva Irina", "logist", "log@post.com", 92623412, 55000, 41);
        emArray[2] = new Employee("Kudryavcev Nikolay", "accountent", "kudr@post.com", 92623412, 75000, 48);
        emArray[3] = new Employee("Morozova Svetlana", "jurist", "moroz@post.com", 92623412, 65000, 37);
        emArray[4] = new Employee("Kondrashov Stepan", "manager", "man@post.com", 92623412, 35000, 23);

        for(int i=0; i<emArray.length; i++){
            if(emArray[i].getAge()>40){
                emArray[i].printInfo();
            }
        }
    }
}
