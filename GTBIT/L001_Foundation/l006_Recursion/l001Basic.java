import java.util.Scanner;

public class l001Basic{
    private static Scanner scn = new Scanner(System.in);

    /* Introduction to Recursion  */

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

    public static void printZigZag(int n){
        if(n==0) return;
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
    }

    //Tower of Hanoi t1 to t2 via t3
    public static void toh(int n, int t1, int t3, int t2){
        if(n==0) return;
        toh(n-1,t1,t2,t3);
        System.out.println(n+"["+t1+" -> "+t2+"]");
        toh(n-1,t3,t1,t2);
    }

    /* Recursion in Arrays  */

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx == arr.length) return;
        displayArrReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }

    // maxOfArray(arr,n-1);
    public static int maxOfArray(int[] arr, int idx){
        if(idx == 0) return arr[0];
        int ans=maxOfArray(arr,idx-1);
        if(ans<arr[idx]) ans=arr[idx];
        return ans;
    }

    // firstIndex(arr,0,x)
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;
        if(arr[idx] == x) return idx;
        return firstIndex(arr,idx+1,x);
    }

    // lastIndex(arr,n-1,x)
    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == -1) return -1;
        if(arr[idx] == x) return idx;
        return lastIndex(arr,idx-1,x);
    }

    

    public static void main(String[] args){
        // printDecreasing(5);
        // fun(5); //find output for this by dry run !

    }
}