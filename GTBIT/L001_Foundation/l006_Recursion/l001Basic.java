import java.util.Scanner;

public class l001Basic{
    private static Scanner scn = new Scanner(System.in);

    public static void printDecreasing1(int n){
        if(n == 0) return;
        System.out.println("Hi"+n);
        printDecreasing1(n-1);
        System.out.println("Bye"+n);
    }

    // Find output when called for n = 5 ?
    public static void fun(int n){
        if(n == 0){
            System.out.println("i have to stop" + n);
            return;
        }
        for(int i=0;i<3;++i) System.out.print(n + "@" +i);
        System.out.println();
        if(n%2 == 0){
            System.out.println("heading towards child function"+n);
        }
        fun(n-1);
        if(n%2 != 0){
            System.out.println("Back to parent function"+n);
        }
        
    }

    public static void printDecreasing(int n){
        if(n==0) return ;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0) return ;
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printIncreasingDecreasing(int n){
        if(n==0) return ;
        System.out.println(n);
        printIncreasingDecreasing(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public static int powerLinear(int x, int n){
        if(n==0) return 1;
        return x*powerLinear(x,n-1);
    }

    public static int powerLogarithmic(int x, int n){
        if(n==0) return 1;
        if(n%2 == 1) return x*powerLogarithmic(x,n/2)*powerLogarithmic(x,n/2);
        else return powerLogarithmic(x,n/2)*powerLogarithmic(x,n/2);
    }

    public static void main(String[] args){
        // printDecreasing(5);
        // fun(5); //find output for this by dry run !

    }
}