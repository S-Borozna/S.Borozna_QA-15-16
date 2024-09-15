import java.util.Arrays;

public class Lesson_AQA_2 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSing();
        printColor();
        compareNumbers();
        System.out.println(limitsSum(17,8));
        System.out.println(typeNumber(8));
        printLine("Уже слишком поздно", 3);
        System.out.println(leapYear(100));
        mutableArray();
        newArray();
        changeArray();
        squareArray();
        System.out.println(Arrays.toString(initValueArray(8, 16)));
    }
    public static void printThreeWords(){
        System.out.println(" Orange\n Banana\n Apple\n" );
    }
    public static void checkSumSing(){
        int a = 5;
        int b = -17;
        if ( a+b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(){
        int value = 1987;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }
    }
    public static void compareNumbers(){
        int a = 98;
        int b = 98;
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean limitsSum(int a, int b){
        int sum = a+b;
        if (sum >= 10 & sum <= 20){
            return true;
        } else return false;
    }
    public static boolean typeNumber(int a){
        if (a >= 0){
            System.out.println("Введенное число положительное");
            return false;
        } else {
            System.out.println("Введенное число отрицательное");
            return true;
        }
    }
    public static void printLine(String b, int a){
        for (int i = 0; i < a; i++) {
            System.out.println(b);
        }
    }
    public static boolean leapYear(int a){
        if (a % 4 != 0){
            return false;
        } else {
            if (a%100==0 & a/100%4!=0){
                return false;
            }
            return true;
        }
    }
    public static void mutableArray(){
        int [] arr = {1,1,0,0,1,0,1,1,0,0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==0) {
                arr[i]=1;
            } else {
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void newArray(){
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void changeArray(){
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void squareArray(){
        int [] [] table = new int [5] [5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (i==j || i+j==4){
                    table[i][j] = 1;
                }
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int [] initValueArray(int len,int initialValue){
        int [] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
        }
        return arr;
    }
}
