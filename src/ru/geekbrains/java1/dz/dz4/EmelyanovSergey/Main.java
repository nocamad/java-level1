package ru.geekbrains.java1.dz.dz4.EmelyanovSergey;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int gameWidth = 3; //Ширина игорового поля
    static int gameHeight = 3; //Высота игорового поля
    static int gameWinLine = 3; //Сколько симолов надо собрать рядом для победы


    static int stepCounter = 0; //количество шагов(итераций) в текущей игре
    static char playerX = 'h';//human  --- может принимать значения h или с (human/computer)
    static char playerO = 'c';//computer

    //параметры ИИ
    static boolean printMinMaxLog = false; //выводить расчет на каждой итерации минимах (для отладки)
    static int gameAnalyzeLevel = 10; //не больше gameWinLine+1 - иначе медленно работает - уровень анализа алгоритма MinMax
    static int counterRate = 0; //количество итераций метода minmax (для контроля выполнения расчета)
    static int counterWinFind = 0; //для MinMax - сколько побед найти в текущем анализе и остановиться
    static int counterLoseFind = 0; //для MinMax - сколько проигрышей найти в текущем анализе и остановиться
    static int minNumberOfExecutedCell = 8;// минимальное количество обсчитываемых ИИ ячеек, если количество меньше, то расширяем поле обсчета

    public static void main(String[] args) {

        System.out.println("---Крестики нолики - реализация алгоритма МиниМакс");
        System.out.println("---тестировалось на размере поля от 3x3 до 8х8");
        System.out.println("---предпочтительный размер 5х5 или 6х6 собрать 4 в ряд");
        System.out.println("---предпочтительный размер 3х3 играет более менее, 5х5 можно найти выигрышные комбинации");
        System.out.println("---может работать в режимах человек-человек, компьютер-человек,компьюер-компьютер");
        System.out.println("------------------------");
        System.out.println("--- рекомендации.");
        System.out.println("--- 3х3 - уровень анализа 10 ");
        System.out.println("--- 5х5 - собрать 4х - уровень анализа 5-6 ");
        System.out.println("--- 6х6 - собрать 4х - уровень анализа 5-6 ");
        System.out.println("--- 8х8 - собрать 4х - уровень анализа 5-6 ");


        //Изменим настроки (размер поля, за кого играть, режимы ИИ)
        setupGame();

        //Начинаем игру
        xogame();

    }


    //Метод ввода настроек
    private static void setupGame() {

        Scanner scan = new Scanner(System.in);
        //Основные настройки
        System.out.println("==================================================");
        System.out.println("ширина поля = " + gameWidth);
        System.out.println("высота поля = " + gameHeight);
        System.out.println("выигрышная комбинация " + gameWinLine + " символа ");
        System.out.println("анализ вниз на " + gameAnalyzeLevel + " уровня (чем больше тем медленнее работает. тестировался 10) ");

        System.out.print("ИЗМЕНИТЬ НАСТРОЙКИ 1-да / любой другой символ = нет");
        if (scan.next().equals("1")) {
            System.out.println("Введите ширину поля [" + gameWidth + "] = ");
            gameWidth = scan.nextInt();
            System.out.println("Введите высоту поля [" + gameHeight + "] = ");
            gameHeight = scan.nextInt();
            System.out.println("Введите кол-во символов выигрышной комбинации [" + gameWinLine + "] = ");
            gameWinLine = scan.nextInt();
            System.out.println("Введите уровень анализа [" + gameAnalyzeLevel + " для 3x3=10, для более 5x5=5-6 иначе медленно ] = ");
            gameAnalyzeLevel = scan.nextInt();
        }

        //Настроки выбора игроков = человек-человек, компьютер-человек,компьюер-компьютер
        System.out.println("Игрок X = [" + playerX + "] " + ((playerX == 'h') ? "human" : "computer"));
        System.out.println("Игрок O = [" + playerO + "] " + ((playerO == 'h') ? "human" : "computer"));
        System.out.print("ВЫБРАТЬ ЗА КОГО ИГРАТЬ 1-да / любой другой символ = нет");
        if (scan.next().equals("1")) {
            System.out.print("Игрок X [" + playerX + "]  h=human / c=computer");
            if (scan.next().equals("h")) {
                playerX = 'h';
            } else {
                playerX = 'c';
            }
            System.out.print("Игрок O [" + playerO + "]  h=human / c=computer");
            if (scan.next().equals("h")) {
                playerO = 'h';
            } else {
                playerO = 'c';
            }
        }

    }

    //Метод инициализации поля ввода
    private static void initMap(char[] arrMap, int[] arrPos) {
        //Массив игрового поля - х и о. ' '-еще не игравшее поле
        for (int i = 0; i < arrMap.length; i++) {
            arrMap[i] = ' ';
        }
        //массив нумерации полей от 1 до n ... проще для игры
        for (int i = 0; i < arrPos.length; i++) {
            arrPos[i] = i + 1;
        }
    }

    //Метод игры. основной
    //в методе запускается основной цикл игры. в каждой итерации один ход (Х или О)
    private static void xogame() {

        char[] arrGame = new char[gameWidth * gameHeight]; //Массив игрового поля (x или 0)
        int[] arrPos = new int[gameWidth * gameHeight]; //Массив нумерации игрового поля ( каждое поле под своим номером)

        initMap(arrGame,arrPos); //инициализируем поле и массив номеров поля

        char stepXO = 'x'; //Переменная текущего хода (х или o) - менятеся каждый ход

        while (true) { //ОСНОВНОЙ ЦИКЛ ИГРЫ. одна итерация = один ход (х или о)
            stepCounter++;
            System.out.println(stepCounter + "=========================================================");
            System.out.println(stepCounter + " ход. Ходит " + stepXO);

            printXO(arrGame, arrPos); //выводим игровое поле на экран

            //Определяем ячейку в которую будем ходить
            int stepNumber = 0; //здесь будет номер ячейки. номера ячеек заданы от 1..n  (для удобства пользователя). =0 пока ячейка не подобрана
            while (true) { //Цикл - пока не будет введена корректная ячейка
                System.out.print(stepXO + " ваш ход :");
                try {
                    Scanner scanner = new Scanner(System.in);
                    boolean thisComputerStep = false;

                    if ((stepXO == 'x') && (playerX == 'c')) thisComputerStep = true;
                    if ((stepXO == 'o') && (playerO == 'c')) thisComputerStep = true;

                    stepNumber = 0; //номер ячейки, в которую будет ходить игрок в этой итерации
                    if (!thisComputerStep) {
                        stepNumber = Integer.parseInt(scanner.next()); //ходит человек - получаем код
                    } else {
                        stepNumber = getBestPosition(arrGame, arrPos, stepXO,arrGame); //ходит компьютер - расчитаем лучший вариант
                    }
                } finally {
                    //проверим - правильно ли получен stepNumber
                    if (stepNumber != 0) { //Если номер ячейки введен правильно - это число, то ПРОВЕРИМ
                        int gameIndex = 0; //это индекс в массиве - можно сделать проще (  -1 к номеру)
                        for (int i = 0; i < arrPos.length; i++) { //найдем индекс
                            if (arrPos[i] == stepNumber) {
                                gameIndex = i;
                                break;
                            }
                        }
                        if (arrGame[gameIndex] == ' ') { //Если выбранная ячейка игрового поля свободна
                            arrGame[gameIndex] = stepXO; //играем эту ячейку
                        } else {
                            stepNumber = 0; //ячейка занята - нельзя играть
                        }
                    }
                }
                if (stepNumber != 0) break; //Если ячейка выбрана верно - останавливаем цикл
            } //Цикл - пока не будет введена корректная ячейка


            //ПРОВЕРЯЕМ результат хода
            //будем проверять выигрыш текущего игрока

            boolean endOfGame = false; //по резульатам проверки эта переменная будет изменена

            //текущий игрок не может проиграть в своей игровой итерции
            if (gameResult(arrGame, stepXO) == 1) { //выигрыш за текущего игрока (1==выигрыш)
                System.out.println("============================");
                System.out.println(stepXO + "  выиграли");
                System.out.println("============================");
                printXO(arrGame, arrPos);
                System.out.println("============================");
                endOfGame = true;
            }

            stepXO = (stepXO == 'x') ? 'o' : 'x';

            //проверим есть ли еще доступные для игры клетки, если нет свободных клеток, то ничья
            boolean HaveNoneGamedCell = false;
            for (int i = 0; i < arrGame.length; i++) {
                if (arrGame[i] == ' ') {
                    HaveNoneGamedCell = true;
                }
            }

            if (!HaveNoneGamedCell) { //доступных ячеек больше нет - это ничья
                System.out.println("============================");
                System.out.println("  ничья");
                System.out.println("============================");
                printXO(arrGame, arrPos);
                System.out.println("============================");
                endOfGame = true;
            }

            if (endOfGame) { //это конец игры
                Scanner scanner = new Scanner(System.in);
                System.out.print("Сыграем еще? 1-да,0-нет");
                int answer = -1;
                while (answer == -1) {
                    try {
                        answer = Integer.parseInt(scanner.next());
                    } finally {
                        if (answer == 0) return;
                        stepXO = 'x';
                        stepCounter = 0;
                        initMap(arrGame, arrPos);
                        //игра начнется заново в том же игровом цикле.
                    }
                }
            }

        }

    }

    //Метод вывода игрового поля
    private static void printXO(char[] arrPrn, int[] arrPos) {

        //Игровое поле состоит из двух частей
        //слева простое игровое поле
        //справа игровое поле с номерами
        //попробовал несколько вариантов - такой вариант мне показался удобнее

        String devideLine = new String();

        //Формируем разделитель строк.
        for (int i = 0; i < gameWidth; i++)  devideLine += "|---";
        devideLine += "|  ";
        for (int i = 0; i < gameWidth; i++)  devideLine += "|----";
        devideLine += "|";


        System.out.println(devideLine); //выводим шапку - шапка==разделитель

        //Формируем игровое поле
        for (int i = 0; i < gameWidth; i++) { //цикл по строкам игрового поля

            //Формируем строку игрового поля
            //Левая часть
            String linePrn = "";
            for (int j = i * gameWidth; j < (i + 1) * gameWidth; j++) {
                linePrn += "| " + arrPrn[j] + " ";
            }
            linePrn += "|  ";

            //Правая часть
            for (int j = i * gameWidth; j < (i + 1) * gameWidth; j++) {
                if (arrPrn[j] == ' ') {
                    linePrn += "| " + arrPos[j] + " ";
                    if (arrPos[j] < 10) linePrn = linePrn + " ";
                } else {
                    linePrn += "|  " + arrPrn[j] + " ";
                }
            }
            linePrn += '|';

            System.out.println(linePrn); //выводим игровую линию
            System.out.println(devideLine); //выводим разделитель
        } //цикл по строкам игрового поля

    }

    //Модуль проверки результата игры .
    //на входе игровой массив и режим игрока (х или о) для кторого проверяется результат
    //игровой массив может быть не только игровым полем, но и любой другой массив для анализа
    private static byte gameResult(char[] arrTest, char playerXO) {
        byte Result = 0; //0=ничья 1=выигрыш -1=проигрыш

        char opponentXO = ((playerXO == 'x') ? 'o' : 'x'); //определяем противника

        //определим шаблоны выигрышных и проигрышных линий, которые будем искать
        //например xxxx - выигрышная линия для х, оооо - проигрышная линия лоя о
        String winLine, loseLine = new String();
        winLine = "";
        loseLine = "";
        for (int i = 0; i < gameWinLine; i++) {
            winLine += playerXO;

            loseLine += opponentXO;
        }

        //проверку игры выполним в три этапа
        //1 этап - проверка строк
        //2 этап - проверка столбцов
        //3 этап - проверка диагоналей

        String testStr = new String(); //в каждом этапе будем формировать тестовую строку.
        //например для проверки строк она будет выглядеть |xxx|xxx|xxx| ... или |<первая строка>|<вторая строка>|....

        byte thisResult;

        int tempIndex = 0;
        //проверим строки
        testStr = "";
        for (int j = 0; j < gameHeight; j++) { //цикл по строкам игрового поля
            testStr += '|'; //начинаем строку с разделителя == '|'
            for (int i = 0; i < gameWidth; i++) { //цикл по столбцам игрового поля
                tempIndex = j * gameWidth + i; //формируем индекс в массиве  игрового поля
                testStr += arrTest[tempIndex]; //формируем строку
            }
        }
        thisResult=getLineResult(testStr, winLine, loseLine); //проверяем результат
        if (thisResult != 0) return thisResult;

        //проверим столбцы - шаблон такой же как в строках
        testStr = "";
        for (int i = 0; i < gameWidth; i++) { //цикл по столбццам
            testStr += '|'; //начинаем строку с разделителя == '|'
            for (int j = 0; j < gameHeight; j++) { //цикл по строкам игрового поля
                tempIndex = j * gameWidth + i; //формируем индекс в массиве  игрового поля
                testStr += arrTest[tempIndex]; //формируем строку
            }
        }
        thisResult=getLineResult(testStr, winLine, loseLine); //проверяем результат
        if (thisResult != 0) return thisResult;

        //Проверяем диагонали - Все диагонали - и главные и второстепенные
        //все диагонали у нас идут сверху вниз
        //вид1 = слева направо, вид 2 - справо налево
        //диагонали разделаются  также как и раньше символом '|'
        testStr = "";
        //проверим диагонали ПРАВЫЕ (слева-направо,сверху-вниз)
        for (int i = 0; i < arrTest.length; i += gameWidth) { //начинем с верхней левой ячейки [0][0] и продвигаемся вправо по столбцам, в сторону [0][n]
            testStr += '|' + getDiagonal(i, arrTest, "LeftToRight") + '|'; //берем диагналь, котрая начинается с выбранной ячейки и идет в направлении LeftToRight
        }
        for (int i = 0; i < gameHeight; i++) { //начинем с верхней левой ячейки [0][0] и продвигаемся вниз (по строкам), в сторону [n][0]
            testStr += '|' + getDiagonal(i, arrTest, "LeftToRight") + '|';//берем диагналь, котрая начинается с выбранной ячейки и идет в направлении LeftToRight
        }

        //проверим диагонали ЛЕВЫЕ (справа-налево,сверху-вниз)
        for (int i = gameWidth - 1; i < arrTest.length; i += gameWidth) {//начинем с верхней правой ячейки [0][n] и продвигаемся влево по столбцам, в сторону [0][0]
            testStr += '|' + getDiagonal(i, arrTest, "RightToLeft") + '|';//берем диагналь, котрая начинается с выбранной ячейки и идет в направлении RightToLeft
        }
        //проверим диагонали левые (справа-налево,сверху-вниз)
        for (int i = 0; i < gameHeight; i++) {//начинем с верхней правой ячейки [0][n] и продвигаемся вниз (по строкам), в сторону [n][n]
            testStr += '|' + getDiagonal(i, arrTest, "RightToLeft") + '|';//берем диагналь, котрая начинается с выбранной ячейки и идет в направлении RightToLeft
        }
        //сформировали все диагонали

        thisResult=getLineResult(testStr, winLine, loseLine); //проверяем результат
        if (thisResult != 0) return thisResult;


        return 0; //пока выигрыша или проигрыша нет
    }

    //получить диагональ слева-направо и сверху вниз начиная от яйчейки Index
    //на входе массив проверяемого игрового поля и направление проверки - LeftToRight/RightToLeft
    private static String getDiagonal(int inIndex, char[] arrTest, String inDirection) {
        String result = new String();
        //определим по индексу массива номера колонки и столбца - потребуются для вычисления диагонали
        int startRow = (int) (inIndex) / gameWidth;
        int startCol = (inIndex) % (gameWidth);
        int tekCol = startCol;
        //int PredRow = startRow-1;
        for (int row = startRow; row < gameHeight; row++) { //цикл сверху вниз - по строкам - до границ игрового поля
            //получаем индекс ячейки, нашей диагонали на текущей строке
            // (по сути каждую итерацию мы смещаемся на одну ячеку вправо или влево - в зависимоти от вида диагонали)
            int index = (startRow * gameWidth) + (row - startRow) * gameWidth + tekCol;
            // тперь надо проверить, что полученнная ячейка находиться в нашей текущей строке
            //если ячейка ушла на следующую строку, то мы просто достигли границы игрового поля
            //и значение этой ячейки учитывать не надо
            int indexRow = (int) (index) / gameWidth; //индекс расчитанной ячейки
            if (((indexRow == row)) && (index < arrTest.length)) { //расчитанная ячейка лежит в текушей строке - и (на всякий случай) в пределах массива
                result += arrTest[index]; //добавляем нашу ячейку в диагональ
            }

            //в заивисмоти от направления - смещаемся вправо или влево
            if (inDirection == "LeftToRight") tekCol++;
            if (inDirection == "RightToLeft") tekCol--;

        }
        return result;
    }

    //Модуль проверки выигрыша или проигрыша по линии.
    //на входе TestLine - линия по шаблону  |<первая строка/столбец/дигональ>|<вторая строка/столбец/дигональ>|...
    // WinLine - что ищем, например xxxx - искомая комбинация для выигрыша
    // LoseLine - что ищем, например oooo - искомая комбинация для проигрыша
    private static byte getLineResult(String TestLine, String WinLine, String LoseLine) {
        if (TestLine.indexOf(WinLine) != -1) {  //нашли WinLine ( -1 будет если ничео не нашли)
            return 1;
        }
        if (TestLine.indexOf(LoseLine) != -1) { //нашли LoseLine ( -1 будет если ничео не нашли)
            return -1;
        }

        return 0; //нет ни выигрыша ни проигрыша
    }


    //Метод формирования лучшего хода по мнению компьютера
    //для решения задачи я попытался применить алгоритм minmax c ограничениями
    //на входе testArr - массив для тестирования (игровое поле)
    // arrPos - массив нумерации игрового поля [1..n] для удобства пользоватея
    // winXO - pза кого играем - за кого надо победить :-)
    private static int getBestPosition(char[] testArr, int[] arrPos, char winXO, char[] inGameArr) {

        //создаем массив реутингов ячеек. в процессе поиска решения
        //мы заполним массив рейтингам, и выберем ячейку с максимальным рейтингом
        double[] arrWinChance = new double[arrPos.length]; //Шансы На победу
        for (int i = 0; i < arrWinChance.length; i++) {
            arrWinChance[i] = 0;
        }

        double[] arrLoseChance = new double[arrPos.length]; //Шансы на проигрыш (шансу на выигрыш у противника)
        for (int i = 0; i < arrLoseChance.length; i++) {
            arrLoseChance[i] = 0;
        }

        //перегружаем массив в тестовый (чтобы не испортить исходный)
        //думаю, что есть методы лучше и быстрее
        char[] tekArr = new char[testArr.length]; //тестовый массив
        for (int i = 0; i < tekArr.length; i++) {
            tekArr[i] = testArr[i];
        }


        char EnemyXO = (winXO == 'x') ? 'o' : 'x'; //это наш противник



        //оптимизируем алгоритм - если еще никто не сиграл, то просто начнем с центра игрового поля
        //проверим - противник уже ходил
        boolean haveEnemySimbol = false;
        for (int i = 0; i < tekArr.length; i++) { //цикл по всем ячейкам игрового поля
            haveEnemySimbol = (tekArr[i] == EnemyXO);
            if (haveEnemySimbol) break;
        }
        if (!haveEnemySimbol) { //противник еще не ходил - начинаем с центра
            int maxChanceIndex = (int) tekArr.length / 2; //примерно :-)
            return arrPos[maxChanceIndex];
        }

        //Сделаем оптимизацию 1
        if (haveEnemySimbol) { //противник ходил - надо считать рейтинги ячеек
            //Оптимизируем алгоритм. Будем рассчитывать не все ячейки игрового поля,
            //а только те, которые прилегают к уже сыгравшим ячекам...
            //т.е. ячейки которые окружают x или о
            //в случае если поле большое, то нет смысла расчитывать пустоту, т.к. расчет начинает сильно тормозить
            //заполним z символом те ячейки, которые можно не расчитывать

            int tekDistaceToEnemy=1; //текущее расстояние от (до) противника (до сыгравшей клетки). Будет увеличивать это расстояние пока размер обсчитываемого поля не станет >= minNumberOfExecutedCell
            //В случае если мы выбрали мало ячеек, то можно расширить расчетное поле.
            //особенно это хорошо в режиме игры 3х3.
            //также если не расширять можно обыгрывать компьютер, ведь он не будет видеть дальше
            //прилегающих ячеек
            while (true) { //Цикл оптимизации обрабатываемого поля

                for (int i = 0; i < tekArr.length; i++) {
                    if ((!HaveEnemyInRegion(testArr, i, 'x',tekDistaceToEnemy)) && (!HaveEnemyInRegion(testArr, i, 'o',tekDistaceToEnemy)))  {
                        if (tekArr[i] == ' ') {
                            tekArr[i] = 'z'; //эту ячейку мы расчитывать не будем
                        }
                    }


                }

                //посчитаем сколько ячеек мы будет рассчитывать.
                int executedCellCount=0;
                int ignoredCellCount=0;
                for (int i = 0; i < tekArr.length; i++) {
                    if (tekArr[i] == ' ') executedCellCount++;
                    if (tekArr[i] == 'z') ignoredCellCount++;
                }
                if (executedCellCount>=minNumberOfExecutedCell) break;
                if (ignoredCellCount==0) break; //увеличить район нельзя - нет больше клеток

                tekDistaceToEnemy++; //увеличим район обсчета на 1 ячейку
                for (int i = 0; i < tekArr.length; i++) { //уберем z для простоты отладки
                    if (tekArr[i] == 'z') tekArr[i] = ' ';
                }

            } //Цикл оптимизации обрабатываемого поля
        } //Конец оптимизации 1


        //Заполняем массив arrChanse рейтингами ячеек
        double maxChanceNumber = arrWinChance[0];
        int maxChanceIndex = 0;
        for (int i = 0; i < tekArr.length; i++) {
            if (tekArr[i] == ' ') {
                counterRate = 0;
                counterWinFind = 0;
                arrWinChance[i] = getRateOfCell(tekArr, winXO, winXO, i, 1,inGameArr);
                //arrLoseChance[i] = getRateOfCell(tekArr, EnemyXO, EnemyXO, i, startLevel);
                System.out.println("Рейтинг ячейки " + arrPos[i] + "["+winXO+"="+ arrWinChance[i]+"]["+EnemyXO+"=" + arrLoseChance[i]+"]");
                maxChanceNumber = arrWinChance[i];
                maxChanceIndex = i;
            }
        }

        //выбираем ячейку с максимальным рейтингом
        for (int i = 0; i < arrWinChance.length; i++) {
            if ((arrWinChance[i] > maxChanceNumber) && (tekArr[i] == ' ')) {
                maxChanceNumber = arrWinChance[i];
                maxChanceIndex = i;
            }
        }
        System.out.println("Выбрана ячейка " + arrPos[maxChanceIndex] + " с ретйтингом " + arrWinChance[maxChanceIndex]);
        return arrPos[maxChanceIndex];
    }

    //Метод возвращает true если противник уже ходил
    private static boolean haveEnemyCells(char[] inTestArr, char enemyXO) {
        for (int i = 0; i < inTestArr.length; i++) {
            if (inTestArr[i] == enemyXO) return true;
        }
        return false;
    }
    //метод возвращает значение ячейки (х или о) и игорового поля, по номеру строки и столбца
    //на входе inTestArr - игровое поле,  tekRow-строка, tekCol-столбец
    private static char getValOnRowCol(char[] inTestArr, int tekRow, int tekCol) {
        int index = 0;
        //если за границами возвращаем z
        if (tekRow < 0) return 'z';
        if (tekCol < 0) return 'z';
        if (tekRow > gameHeight - 1) return 'z';
        if (tekCol > gameWidth - 1) return 'z';

        index = tekRow * gameWidth + tekCol; //рассчитываем индекс в массиве
        return inTestArr[index]; //возвращаем результат (х или о или пусто или z)
    }

    //Метод проверки окружения ячейки
    //если рядом с ячейкой замечены x или o, то выдаем истину
    //регион обнаружения - все ячейки, прилегающие к тестовой
    //на входе - inTestArr массив игорового поля, i-индекс проверямой ячейки, enemyXO какие ячейки ищем (х или о)
    private static boolean HaveEnemyInRegion(char[] inTestArr, int inIndex, char inEenemyXO, int inDistanceToEnemy) {

        //определяем положение в массиве
        int tekCol, tekRow;
        tekRow = (int) inIndex / gameWidth;
        tekCol = inIndex - tekRow * gameWidth;

        //это быстрый способ - когда расстояние = 1 ячейка
        if (inDistanceToEnemy==1) { //для упрощения алгоритма выделим частный случай
            //проверяем все поля на 360 градусов
            //проверка выхода за границы игрового поля находится в методе getValOnRowCol
            if (getValOnRowCol(inTestArr, tekRow, tekCol - 1) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow - 1, tekCol - 1) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow - 1, tekCol) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow - 1, tekCol + 1) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow, tekCol + 1) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow + 1, tekCol + 1) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow + 1, tekCol) == inEenemyXO) return true;
            if (getValOnRowCol(inTestArr, tekRow + 1, tekCol - 1) == inEenemyXO) return true;
            return false;
        } //distanceToEnemy==1

        //а теперь если расстояние больше чем одная ячейка - долгий способ
        if (inDistanceToEnemy > 1) { //для упрощения алгоритма выделим случай если расстояние >1

            //Пробежимся по всем ячейкам игрового поля с заданным inEenemyXO
            //если расстояние до нашей ячейки <= заданной дистанции
            //то возвратим true
            for (int i = 0; i < inTestArr.length; i++) {
                if (inTestArr[i] == inEenemyXO) {
                    int thisRow = (int) i / gameWidth;//определим строку - от 0 до
                    int thisCol = i - thisRow * gameWidth; //определим колонку от 0 до
                    int distanceRow = Math.abs(thisRow - tekRow); //расстояние от заданной ячейки
                    int distanceCol = Math.abs(thisCol - tekCol); //расстояние от заданной ячейки
                    if ((distanceRow <= inDistanceToEnemy) && (distanceCol <= inDistanceToEnemy)) {
                        return true;
                    }

                }
            }

            return false; //не нашли ячеек inEenemyXO ближе к inIndex чем inDistanceToEnemy
        } //distanceToEnemy>1

        return false;
    }

    //Метод получения рейтинга ячейки
    //на входе inTestArr - тестируемый массив игрового поля,
    // inGameXO - текущий режим (чей сейчас ход - х или о)
    // inWinXO - за кого нам надо выигрывать (х или о)
    // inIndex - индекс ячейки, чей рейтинг мы рассчитываем
    // inLevel - уровень анализа (от 1 до максимально возможного заданного уровня - gameAnalyzeLevel )
    // inGameArr - массив текущего игрового поля для коэффициента растояния до противника
    // метод рекусривный, в каждом уровне рекурсии inLevel++
    // чтобы не рассчитывать ненужные варианты и не тормозить процесс необходим inLevel.
    // по идее inLevel должен быть не меньше длины выигрывающей комбинации,
    // например для расчета ххх (классические 3х3) считать больше 3 уровней нет смысла
    // для расчета хххx интересно играть в поле 5х5 6х6 7х7 можно посчитать 5 уровней
    // метод с inLevel>gameAnalyzeLevel прерываем с нулевым результатом
    private static double getRateOfCell(char[] inTestArr, char inGameXO, char inWinXO, int inIndex, int inLevel, char[] inGameArr) {


        //перегружаем массив игорового поля, чтобы не изменить переданный
        char[] tekArr = new char[inTestArr.length]; //создаем временный массив
        for (int i = 0; i < tekArr.length; i++) {
            tekArr[i] = inTestArr[i];
        }


        boolean mayStopFind = false; //могу остановиться? тут были еще разные варианты, поэтому переменная - конечно она не обязательна в данном случае
        if (inLevel > gameAnalyzeLevel) mayStopFind = true;
        if (mayStopFind) return 0;


        counterRate++; //для контроля - сколько итераций метода уже сделано


        char enemyXO = (inWinXO == 'x') ? 'o' : 'x'; //наш противник


        tekArr[inIndex] = inGameXO; //устанвливаем в нашу ячейку игровой знак, как будто мы в нее сиграли
        //и пытаемся высичлить к чему приведет игра в эту ячейку

        double result = 0; //возвращает в концен результат (рейтинг)
        int nowMyResult = gameResult(tekArr, inWinXO); //НАШ резульат 1-выиграли -1-пороиграли
        int nowEnemyResult = gameResult(tekArr, enemyXO); //резульат противника 1-выиграли -1-пороиграли - можно использовать для блокирования хода противника, если он выигрывает, то надо ему крылышки то подрезать
        //в зависимости от уровня расчета - результат будет иметь разную ценнностт
        //если это первая итерация и мы выигрываем, то рейтинг ячейки высокий,
        //если это 5-я итерация, то вероятность наступления такого события низкая, и рейтинг низкий

        //подбор этих коэффициентов (resLevelWin и resLevelLose) решает
        //в идеале - сумма коэффициентов следующего уровня не должна превышать сумму предыдущего
        //с каждым уровнем анализа коэффициенты должны уменьшаться
        double resLevelWin = 10 * (gameAnalyzeLevel - inLevel + 1); // кратно 10 для выигрыша
        double resLevelLose = -1000 * (gameAnalyzeLevel - inLevel + 1); //кратно 1000 проигрыша - проигрывать неохота

        double MaxReturnValue = Math.pow(4,gameAnalyzeLevel);
        MaxReturnValue=Integer.MAX_VALUE;

        //Введем коэффициент удаленности от противника - чем дальше, тем меньше рейтинг
        if (haveEnemyCells(inGameArr,enemyXO)) {
            int distanceToEnemy=1;
            while (true) {
                resLevelWin=resLevelWin/10;
                resLevelLose=resLevelLose/10;
                if (HaveEnemyInRegion(inGameArr,inIndex,enemyXO,distanceToEnemy)) break;
                distanceToEnemy++;
            }
        }




        switch (nowMyResult) {
            case 1:
                counterWinFind++; //количество найденных выигрышей - сйечас не используется, но можно подумать
                result=resLevelWin; //возвращаем рейтинг
            case -1:
                counterLoseFind++; //количество найденных проигрышей - сйечасне используется, но можно подумать
                result=resLevelLose; //возвращаем рейтинг
        }

        //Отпимизируем - если мы выигрываем прям сейчас, и это уровень итерации = 1 - это значит мы выигрываем этим ходом
        //тогда выдадим максимальный рейтинг ячейке
        if ((nowMyResult == 1) && (inLevel == 1)) {
            result=MaxReturnValue;
        }
        //Если противник выигрывает во второй итерации, то закроем ему эту возможность
        //если коэффициенты resLevelWin и resLevelLose правильно подобраны, то это происходит само собой
        if ((nowEnemyResult == 1) && (inLevel == 2) && (inGameXO==enemyXO)) {
            result=MaxReturnValue-2*MaxReturnValue;
        }




        if ((printMinMaxLog) && (result!=0)) {
            String logStr = new String();
            for (int k=1;k<=inLevel;k++) logStr+=""+k;
            logStr="......["+counterRate+"]"+logStr+" level["+inLevel+"] player["+inGameXO+"] index["+inIndex+"] result["+result+"]"+ Arrays.toString(tekArr);
            System.out.println(logStr);
        }

        if (result!=0) { //если на данном этапе есть результат - то нет смысла обрабатывать остальные ячейки
            return result;
        }


        //Обрабатываем все остальные ячейки, т.к. пока результат не ясен
        for (int i = 0; i < tekArr.length; i++) {
            if (tekArr[i] == ' ') {

                char inNextXO = (inGameXO == 'x') ? 'o' : 'x';
                double rateOfThisCell=getRateOfCell(tekArr, inNextXO, inWinXO, i, inLevel+1,inGameArr);
                result = result +rateOfThisCell;

            }
        }

        return result;

    }

}