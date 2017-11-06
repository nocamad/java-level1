package ru.geekbrains.java1.dz.dz5.KopeikinAlexey;

public class Main {
    public static void main(String[] args){
        String s = "String";

        //Employees EMP1=new Employees("ИвановИИ","инженер","Ivanov@Ivan.ru", "+79654789521",30000.00,45 );

       //EMP1.PRN();

        Employees[] persArray = new Employees[5];
        persArray[0]=new Employees("Абрикосова М Д", "секретарь", "Abric@firma.com","+79543214785",28456.21, 28);
        persArray[1]=new Employees("Кноль СК","бухгалтер","khnoll@firma.com","+79849652314",854751.23,54);
        persArray[2]=new Employees("Собакина ИГ","кастеллянша","sobak@firma.com","+785496514785",19854.85,67);
        persArray[3]=new Employees("Петров Р А","техник","Petrov@firma.ru","+79874563215",45897.51,48);
        persArray[4]=new Employees("Сергеев Г В","Инженер","Sergeev@firma.com","+798145678965",89254.54,35);


       // System.out.println(persArray[3]);
        for (int i=0;i<persArray.length;i++){
            //int A=persArray[i].getAge();
            if(persArray[i].getAge()>40){persArray[i].PRN();}

        }


  }
}
