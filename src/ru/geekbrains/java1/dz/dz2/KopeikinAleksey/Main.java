package ru.geekbrains.java1.dz.dz2.KopeikinAleksey;

public class Main {
    public static void main(String[] args) {
        int ar[]={1,2,3,4,5,6,7,8,9};
        int n=5;
        int[] arrs = {3,6,12,28,34,32,7,89,5,9,54,73,1};
        Task7(ar,n);
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
        Task6(arrs);
    }




    public static void Task7(int arr[], int n) {

        int l = arr.length;
        int max=l-1;
        int d=l-n;



        if (n > 0) {
            int i = n;
            int nn=l;
            int ii = 0;
            int dd=d;
            while (dd>0){
                arr[d]=arr[ii];
                d++;ii++;dd--;

System.out.println("d="+d+"_;_l="+l);
            }


//            }
//            while (i < l) {
//                arr[ii] = arr[i];
//
//
//                i++;
//                ii++;
//            }
           // arr[3] = arr[5];
            int a = 0;
            while (a < l) {
                System.out.print(arr[a] + ")_");
                a++;
            }
            System.out.println("");
            System.out.println(arr[3]);


        }
    }

//////////////////////////////////////////////////////////////задание 1 //////////////////////////////

    public static void Task1(){

        int[]arr={1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        int l=arr.length;
        int i=0;
        while(i<l){

            switch (arr[i]){
                case 0: arr[i]=1;break;
                case 1: arr[i]=0;break;

            }

            System.out.print(arr[i]+"_");
            i++;
        }



    }


    ////////////////////////////////////////////задание 2/////////////////////////////////////////


    public static void Task2(){
        System.out.println();
        int[]arr=new int[8];
        int l=arr.length;
        int a=0;
        for(int i=0;i<l;i++){

            arr[i]=a;

            a=a+3;

            System.out.print(arr[i]+"_");
        }



    }
    ///////////////////////////////////////////////////задание 3////////////////////////////////////////////////////


    public static void Task3(){
System.out.println();
        int[]arr={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int l = arr.length;
        int i=0;
        while(i<l){
            if(arr[i]<6){arr[i]=arr[i]*2;}
            System.out.print(arr[i]+"_");
            i++;
        }

    }
//////////////////////////////Task4///////////////////////////задание 4////////////////////////////////////////////////////////


        public static void Task4(){
        System.out.println("Task4");

          int[][]squareArr=new int[10][10];
          int i=0;
          int l=squareArr.length;
          while (i<l){
              for(int h=0;h<l;h++){
                  if(h==i){squareArr[i][h]=1;}
                System.out.print(squareArr[i][h]+" ");

              }
System.out.println("");
              i++;
          }

    }

//////////////////////////////////////////////// задание 5 //////////////////////////////////////////


public static void Task5(){

            int[] arr = {3,6,12,28,34,32,7,89,5,9,54,73,1};
            int min=0;
            int max=0;
            for(int i=0;i<arr.length;i++){
                if(i==0){min=arr[i];}
                if(min>arr[i]){min=arr[i];}
                if(max<arr[i]){max=arr[i];}

            }
            System.out.println("min="+min+" max="+max);


}
//////////////////////////////////////////Задание 6 ////////////////////////////////////////////////////////

public static boolean Task6(int[] arr){


    int i=0;
    int mid=arr.length/2;
    int left=0;int right=0;
    while(i<arr.length){
        if(i<mid){left=left+arr[i];}
        else {right=right+arr[i];}
    i++;
    }
    if(left==right){
        return true;
    }else {return false;}


}
















}
