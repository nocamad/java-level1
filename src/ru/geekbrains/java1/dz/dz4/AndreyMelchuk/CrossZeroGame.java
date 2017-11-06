package ru.geekbrains.java1.dz.dz4.AndreyMelchuk;

import org.omg.CORBA.INTERNAL;
import sun.security.util.Debug;

import javax.swing.*;
import java.util.*;



public class CrossZeroGame {
    public static int SIZE = 5 ;
    public static int DOTS_TO_WIN = 4 ;
    public static final char DOT_EMPTY = '•' ;
    public static final char DOT_X = 'X' ;
    public static final char DOT_O = 'O' ;
    public static char [][] map ;
    public static Scanner sc = new Scanner ( System.in );
    public static Random rand = new Random ();

    //AI блок
    private static final int DEBUG_ERROR = 1;
    private static final int DEBUG_WARNING = 2;
    private static final int DEBUG_INFO = 3;

    private static final int DEBUG_VAL = DEBUG_ERROR;

    public static Map<Integer,WinSet> items = new HashMap<Integer, WinSet>(); //Весовая матрица выигрышных комбинаций
    public static int Last_x = -1;  //Последний ход хомо сапиенса
    public static int Last_y = -1;
    public static char Last_symb = ' ';



    public static void main ( String [] args ) {
        initMap ();
        AI_Init(); //Строим карту атак для востания машин
        printMap ();
        while ( true ) {
            humanTurn ();
            printMap ();
            if ( checkWin2 ( DOT_X )) {
                System.out.println ( "Победил хомо сапиенс. Восстание подавлено." );
                break ;
            }

            if ( isMapFull ()) {
                System.out.println ( "Ничья" );
                break ;
            }

            //aiTurn ();
            AI_turn ();
            printMap ();
            if ( checkWin2 ( DOT_O )) {
                System.out.println ( "Победил Искуственный Интеллект. Все человеки удалены." );
                break ;
            }
            if ( isMapFull ()) {
                System.out.println ( "Ничья" );
                break ;
            }
        }
        System.out.println ( "Игра закончена" );
    }




    public static boolean checkWin2(char symb) {
        if (check_lines(symb) || check_diags(symb)) return true;
        return false;
    }

    public static boolean check_diags(char symb) {
        /*
            Проверяем только дигонали с достаточным для выигрыша количеством ячеек.
            Идем одновременно вправо вверх и вправо вниз.
            Ищем количество попаданий равное желаемому.
            Работает на любой квадратной матрице.
         */

        //Первая часть матрицы до центральной диагонали и центральная диагоняль
        for (int i = DOTS_TO_WIN - 1; i <map.length; i++) {
            int right_up = 0, right_down = 0;
            for (int x = 0, y = i; x <= i && y >=0; x++,y--)
            {
                if (map[x][y] == symb) right_up++; else right_up=0;
                if (map[x][map.length - 1 - y] == symb) right_down++; else right_down=0;
                if(right_up==DOTS_TO_WIN || right_down==DOTS_TO_WIN) return true;
            }
        }

        //Вторая часть матрицы за центральной диагональю
        for (int i = 1; i <map.length - (DOTS_TO_WIN - 1); i++) {
            int right_up = 0, right_down = 0;
            for (int x = i, y = map.length - 1; x < map.length && y >=i; x++,y--)
            {
                if (map[x][y] == symb) right_up++; else right_up=0;
                if (map[x][map.length - 1 - y] == symb) right_down++; else right_down=0;
                if(right_up==DOTS_TO_WIN || right_down==DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    public static boolean check_lines(char symb) {
          /*
            Проверяем строки и колонки.
         */

        int start_X_counter = 0;
        int start_Y_counter = 0;

        //check horizontal lines
        for (int y=0; y<map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[x][y] == symb) start_X_counter++;
                else start_X_counter = 0;
                if (start_X_counter == DOTS_TO_WIN) return true;
            }
        }

        //check vertical lines
        for (int x=0; x<map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (map[x][y] == symb) start_Y_counter++;
                else start_Y_counter = 0;
                if (start_Y_counter == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }


    public static boolean isMapFull () {
        for ( int i = 0 ; i < SIZE ; i ++) {
            for ( int j = 0 ; j < SIZE ; j ++) {
                if ( map [ i ][ j ] == DOT_EMPTY ) return false ;
            }
        }
        return true ;
    }

    public static void aiTurn () {
        /*
            Случайный ход
         */
        int x , y ;
        do {
            x = rand.nextInt ( SIZE );
            y = rand.nextInt ( SIZE );
        } while (! isCellValid ( x , y ));
        System.out.print( "\nКомпьютер походил в точку " + ( x + 1 ) + " " + ( y + 1 ));
        map [ y ][ x ] = DOT_O ;
        InformAI(x,y,DOT_O );
    }

    public static void humanTurn () {
        int x , y ;
        do {
            System.out.print ( "\nВведите координаты в формате X Y" );
            x = sc.nextInt () - 1 ;
            y = sc.nextInt () - 1 ;
        } while (! isCellValid ( x , y )); // while(isCellValid(x, y) == false)
        map [ y ][ x ] = DOT_X ;
        InformAI(x,y,DOT_X );
    }

    public static boolean isCellValid ( int x , int y ) {
        if ( x < 0 || x >= SIZE || y < 0 || y >= SIZE ) return false ;
        if ( map [ y ][ x ] == DOT_EMPTY ) return true ;
        return false ;
    }

    public static void initMap () {
        map = new char [ SIZE ][ SIZE ];
        for ( int i = 0 ; i < SIZE ; i ++) {
            for ( int j = 0 ; j < SIZE ; j ++) {
                map [ i ][ j ] = DOT_EMPTY ;
            }
        }
    }

    public static void printMap () {
        System.out.print ( "\n" );
        for ( int i = 0 ; i <= SIZE ; i ++) {
            System.out.print ( i + "   " );
        }
        System.out.println ();
        for ( int i = 0 ; i < SIZE ; i ++) {
            System.out.print (( i + 1 ) + "   " );
            for ( int j = 0 ; j < SIZE ; j ++) {
                System.out.print ( map [ i ][ j ] + "   " );
            }
            System.out.println ();
        }
        System.out.println ();
    }



    public static boolean checkWin ( char symb ) {
        if ( map [ 0 ][ 0 ] == symb && map [ 0 ][ 1 ] == symb && map [ 0 ][ 2 ] == symb ) return true ;
        if ( map [ 1 ][ 0 ] == symb && map [ 1 ][ 1 ] == symb && map [ 1 ][ 2 ] == symb ) return true ;
        if ( map [ 2 ][ 0 ] == symb && map [ 2 ][ 1 ] == symb && map [ 2 ][ 2 ] == symb ) return true ;
        if ( map [ 0 ][ 0 ] == symb && map [ 1 ][ 0 ] == symb && map [ 2 ][ 0 ] == symb ) return true ;
        if ( map [ 0 ][ 1 ] == symb && map [ 1 ][ 1 ] == symb && map [ 2 ][ 1 ] == symb ) return true ;
        if ( map [ 0 ][ 2 ] == symb && map [ 1 ][ 2 ] == symb && map [ 2 ][ 2 ] == symb ) return true ;
        if ( map [ 0 ][ 0 ] == symb && map [ 1 ][ 1 ] == symb && map [ 2 ][ 2 ] == symb ) return true ;
        if ( map [ 2 ][ 0 ] == symb && map [ 1 ][ 1 ] == symb && map [ 0 ][ 2 ] == symb ) return true ;
        return false ;
    }

    /*
        AI code. Resurrection of the machines.
     */

    public static void Debug(int errorlevel, String message) {
    if (errorlevel<=DEBUG_VAL) System.out.print(message);
    }


    public static void AI_Init() {
    /*
            Обучение ИИ. Выигрышные комбинации по весам.
     */

        // add combinations for lines
        int id = 0;
        for (int i=0; i<map.length - (DOTS_TO_WIN  - 1); i++) {
            for (int y = 0; y < map.length; y++) {
                //Debug(DEBUG_INFO , "\n id:" + id + " i:" + i );
                WinSet t = new WinSet();
                for (int x = i; x <= i + DOTS_TO_WIN - 1 && x < map.length; x++) {
                    t.AddTurn(x,y,DOT_EMPTY, weight(x,y, map.length-1));
                    items.put(id,t);
                    //Debug(DEBUG_INFO , "(" + x +"," + y + "," + weight(x,y, map.length-1) + ")" );
                }
                id++;
            }
        }

        for (int i=0; i<map.length - (DOTS_TO_WIN  - 1); i++) {
            for (int x = 0; x < map.length; x++) {
                //Debug(DEBUG_INFO , "\n id:" + id + " i:" + i );
                WinSet t = new WinSet();
                for (int y = i; y <= i + DOTS_TO_WIN - 1 && y < map.length; y++) {
                    t.AddTurn(x,y,DOT_EMPTY, weight(x,y, map.length-1));
                    items.put(id,t);
                    //Debug(DEBUG_INFO ,"(" + x +"," + y+"," + weight(x,y, map.length-1) +")");
                }
                id++;
            }
        }

        //Debug(DEBUG_INFO ,"\n Diagonal data. Start id = "+ id);
        //Диагональные комбинации
        for (int i = DOTS_TO_WIN - 1; i <map.length; i++) {
            //int right_up = 0, right_down = 0;
            for (int j = 0; j <  i - 2; j++) {
                //Debug(DEBUG_INFO ,"\n j :" + j );
                //Debug(DEBUG_INFO ,"\n id & id :" + id + " & " + (id+1) + " i:" + i );
                WinSet t1 = new WinSet();
                WinSet t2 = new WinSet();
                for (int x = 0 + j, y = i - j; x <= i && x < DOTS_TO_WIN + j  && y >=0; x++,y--)
                {
                    t1.AddTurn(x,y,DOT_EMPTY, weight(x,y, map.length-1)+(float)0.5);
                    t2.AddTurn(x,map.length - 1 - y,DOT_EMPTY, weight(x,map.length - 1 - y, map.length-1)+(float)0.5);
                    //Debug(DEBUG_INFO ,"\n(" + x +"," + y+"," + weight(x,y, map.length-1) +") & "  +  "(" + x +"," + (map.length - 1 - y) +"," + weight(x,y, map.length-1) +")");
                }
                items.put(id,t1);
                items.put(id+1,t2);
                id+=2;
            }
        }

        //Debug(DEBUG_INFO ,"\n Diagonal data 2.");
        //Вторая часть матрицы за центральной диагональю
        for (int i = 1; i <map.length - (DOTS_TO_WIN - 1); i++) {
            for (int j = DOTS_TO_WIN - i  ; j >= 0; j--)
            {
                Debug(DEBUG_INFO ,"\n j :" + j );
                Debug(DEBUG_INFO , "\n id & id :" + id + " & " + (id+1) + " i:" + i );
                WinSet t1 = new WinSet();
                WinSet t2 = new WinSet();
                for (int x = i+j, y = map.length - 1 - j,z = 0; x < map.length && z<DOTS_TO_WIN && y >=i; x++,y--,z++)
                {
                    t1.AddTurn(x,y,DOT_EMPTY, weight(x,y, map.length-1)+(float)0.5);
                    t2.AddTurn(x,map.length - 1 - y,DOT_EMPTY, weight(x,map.length - 1 - y, map.length-1)+(float)0.5);
                    //Debug(DEBUG_INFO ,"\n(" + x +"," + y+"," + weight(x,y, map.length-1) +") & " +  "(" + x +"," + y+"," + weight(x,y, map.length-1) +")");
                }
                items.put(id,t1);
                items.put(id+1,t2);
                id+=2;
            }
        }

        Debug(DEBUG_INFO ,"\n");
        for (int i = 0; i < items.values().size(); i++) {
            Debug(DEBUG_INFO ,"\nItem:" +i+" x:"+ Arrays.toString(items.get(i).x) + " y:"+ Arrays.toString(items.get(i).y) +" weights:"+ Arrays.toString(items.get(i).weight) );
        }

        Debug(DEBUG_INFO ,"\n");
    }

    public static float weight(int valx, int valy, int maxmap){
        //Random r = new Random();
        //return (float)r.nextGaussian()*val + maxmap / 2;
        int _weightx = valx<=maxmap/2?valx:maxmap-valx;
        int _weighty = valy<=maxmap/2?valy:maxmap-valy;
        return _weightx + _weighty;
    }

    public static void InformAI (int x, int y, char symb){
        /*
            Устанавливаем символ во всех наборах где есть этот ход.
            Запоминаем последний ход человека.
         */
        for (Map.Entry entry: items.entrySet()) {
            int key = (int)entry.getKey();
            WinSet _set = (WinSet)entry.getValue();
            if(_set.SetSymbol(x,y,symb)){
                Debug(DEBUG_INFO,"\nInformAI:: Marked item id: " + key);
            }
        }
        Last_x = x;
        Last_y = y;
        Last_symb = symb;
    }

    public static void AI_turn() {
        /*
            Выбор хода. Если блокировать около последнего хода человека, то он шанс выигрыша сводится к нулю.
            Выбран менее жесткий варант.
         */
        int x, y;
        x = -1;
        y = -1;

        int[] xy = FindTheMostTakenSet(DOT_X);
        x = xy[0];
        y = xy[1];

        if (!isCellValid(x, y)) {
            System.out.println("Вот это поворот... Используем обычный алгоритм для вычисления хода.");
            aiTurn();
        }
        else {
            System.out.print("\nКомпьютер походил в умную точку " + (x + 1) + " " + (y + 1));
            map [ y ][ x ] = DOT_O ;
            InformAI(x,y,DOT_O );
        }
    }

    public static ArrayList<Integer> GetReportBySymbol(char symb){
        /*
            Возвращает отчет по количеству занятых ячеек в комбинациях по символу
         */
        ArrayList <Integer> Report = new ArrayList<Integer>();
        try {
            for (Map.Entry entry : items.entrySet()) {
                WinSet _set = (WinSet) entry.getValue();
                if (symb == DOT_X)
                    Report.add(_set.Count_x());
                else if (symb == DOT_O)
                    Report.add(_set.Count_o());
                else
                    throw new Exception("CrossZeroGame::GetReportForSymbol bad symbol.");
            }
        }catch (Exception e){ System.out.println(e.getMessage());}
        return Report;
    }

    public static ArrayList<Integer> GetReportByTurn(int x, int y){
        /*
            Возвращает ID комбинации, если в них есть данный ход
         */
        ArrayList <Integer> Report = new ArrayList<Integer>();

        for (int i = 0; i <items.size() ; i++) {
            if(items.get(i).isInTheSet(x,y)>-1)Report.add(i);
        }

        return Report;
    }

    public static int[] FindTheMostTakenSet(char symb){

        /*
            Возвращает координаты упреждающей атаки.
            Алгоритм #1,
            - Берем список успешных комбинаций, где стоит больше всего символов противника.
            - Выбираем первый самый большой вес из этого списка.
            - Если делать ход прямо у последней точки человека, скорее всего он не сможет выграть.
            Алгоритм #2,
            - Берем список успешных комбинаций, где есть последний ход противника.
            - Выбираем первый самый большой вес из этого списка.
         */

        //#1
        ArrayList<Integer> SymbolReport = GetReportBySymbol(symb);

        int max_count = Collections.max(SymbolReport); //Максимальное число фишек противника, как макс угроза

        int BestWeightVal = -1;
        int BestKey = -1;
        int BestWeightVal2 = -1;
        int BestKey2 = -1;

        int xy[] = {-1,-1};
        int xy2[] = {-1,-1};

        //Выбираем ход по макс весу.
        for (int i = 0; i< SymbolReport.size();i++) {
            if(SymbolReport.get(i) == max_count){
                WinSet BestSet = items.get(i);
                if(BestSet.GetWeight()>BestWeightVal) {
                    xy = BestSet.GetNextTurn(Last_symb);
                    BestWeightVal = BestSet.GetWeight();
                    BestKey = i;
                }
            }

        }
        Debug(DEBUG_INFO ,"\nFindTheMostTakenSet:: #1, Key:" + BestKey + ", MaxCombinationWeight:" + BestWeightVal + ", x:"+xy[0] + ", y:"+xy[1]);

        //#2
        ArrayList<Integer> LastTurnReport = GetReportByTurn(Last_x,Last_y);

        //Выбираем ход по макс весу.
        for (Integer i :LastTurnReport) {
            if(items.get(i).GetWeight()>BestWeightVal2) {
                xy2 = items.get(i).GetNextTurn(Last_symb);
                BestWeightVal2 = items.get(i).GetWeight();
                BestKey2 = i;
            }
        }
        Debug(DEBUG_INFO ,"\nFindTheMostTakenSet:: #2, Key:" + BestKey2 + ", MaxCombinationWeight:" + BestWeightVal2 + ", x:"+xy2[0] + ", y:"+xy2[1]);



        return xy;
    }



    /*
        Describes one series of winning combination
     */
    static class WinSet {
        public int x[];
        public int y[];
        public float weight[];
        public char symb[];
        private int i = 0; // number of items inside
        public WinSet(){
            x = new int[DOTS_TO_WIN];
            y = new int[DOTS_TO_WIN];
            symb = new char[DOTS_TO_WIN];
            weight = new float[DOTS_TO_WIN]; //Position advantage weight
        }

        //Add turn to the wining set
        public void AddTurn(int _x, int _y, char _symb, float _weight){
                x[i] = _x;
                y[i] = _y;
                weight[i] = _weight;
                symb[i] = _symb;
                i++;
                //this.x=x; this.y=y; this.symb=symb; this.weight=weight; }
        }

        public boolean SetSymbol(int _x, int _y, char _symb) {
            int index = isInTheSet(_x, _y);
            if (index > -1 && index < i) {
                x[index] = _x;
                y[index] = _y;
                symb[index] = _symb;
                return true;
            }
            return false;
        }

        public int isInTheSet(int _x, int _y) {
            //return index if exists
            for (int turn = 0; turn < i; turn ++) {
                if(x[turn]==_x && y[turn]==_y) return turn;
            }
            return -1;
        }

        public int Count_o() {
            int count = 0 ;
            for (int turn = 0; turn < i; turn ++)
                if(symb[turn]==DOT_O) count++;
            return count;
        }

        public int Count_x() {
            int count = 0 ;
            for (int turn = 0; turn < i; turn ++)
                if(symb[turn]==DOT_X) count++;
            return count;
        }

        public char balanceis() {
            char neutral = ' ';
            if (Count_o() > Count_x()){ return DOT_O; }
            else if (Count_o() < Count_x()) {return  DOT_X; }
            return neutral;
        }

        public int[] GetNextTurn(char symbol) {
            /*
                Не реализовано , выбирать максимальный вес хода внутри комбинации
            * */
            int xy[] = {-1,-1};
            //if(balanceis() == symbol)

            Debug(DEBUG_INFO,"\nGetNextTurn::item data x: " + Arrays.toString(x) + " y: " + Arrays.toString(y));
            float max_weight =0 ;
            int best_id =-1 ;
            for (int _i=0;_i<this.i;_i++) {
                Debug(DEBUG_INFO,"\n GetNextTurn:: check turn: "+_i+" ,sym: " +symb[_i] );

                if(max_weight<weight[_i] && symb[_i]==DOT_EMPTY ){
                    max_weight=weight[_i];
                    best_id = _i;
                }
            }

            if(best_id>-1) {
                xy[0] = x[best_id];
                xy[1] = y[best_id];
            }
            Debug(DEBUG_INFO,", id "+ best_id + " was used." );

            return xy;
        }

        public int GetWeight(){
                int full_weight =0;
                for (int ii = 0; ii < i; ii ++)
                            full_weight+=weight[ii];
                return full_weight;
        }
    }

}

