import java.util.Scanner;
public class l001{
    public static Scanner scn = new Scanner(System.in);
    public static void printHello(){
        System.out.println("Hi, There");
    }
    public static void takeInput(){
        int n = scn.nextInt();
        System.out.println("Your number "+ n);
    }
    public static void workWithDataType(){
        int a=10;
        int b=20;
        System.out.println("Value of A: "+ a);
        System.out.println("Value of B: "+ b);
    }
    public static void main(String[] args){
        // printHello();
        // workWithDataType();
        takeInput();
    }
}