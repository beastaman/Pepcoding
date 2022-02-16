import java.util.Scanner;
import java.util.ArrayList;

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
        printZigZag(n-1);
        System.out.print(n+" ");
        printZigZag(n-1);
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

    // lastIndex(arr,n-1,x) traversing n-1 to 0
    public static int lastIndex1(int[] arr, int idx, int x){
        if(idx == -1) return -1;
        if(arr[idx] == x) return idx;
        return lastIndex1(arr,idx-1,x);
    }

    // lastIndex(arr,n-1,x) traversing 0 to n-1
    public static int lastIndex2(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;
        int res = lastIndex2(arr,idx+1,x);
        if(res == -1 && arr[idx] == x)  return idx;
        return res;
    }

    // All Indices Of Array
    // public static int func(int[] arr, int x, int idx){
    //     if(idx==arr.length) return 0;
    //     int res=func(arr,x,idx+1);
    //     if(arr[idx]==x) ++res;
    //     return res;
    // }
    // public static void fillx(int[] xrr, int xidx, int[] arr,int idx,int x){
    //     if(xidx == xrr.length || idx == arr.length) return;
    //     if(arr[idx]==x){
    //         xrr[xidx++]=idx;
    //     }
    //     fillx(xrr,xidx,arr,idx+1,x);
    // }
    // public static int[] allIndices(int[] arr, int x, int idx, int count) {
    //     // write ur code here
    //     int freq = func(arr,x,0);
    //     int[] xrr = new int[freq];
    //     fillx(xrr,0,arr,0,x);
    //     return xrr;
    // }

    // All Indices of Array
    public static int[] allIndices(int[] arr, int x, int idx, int count) {
        if(idx == arr.length){
            int[] base = new int[count];
            return base;
        }
        if(arr[idx] == x) ++count;
        int[] ans = allIndices(arr,x,idx+1,count);
        if(arr[idx] == x) ans[count-1] = idx ;
        return ans;
    }

    /* Recursion with ArrayList */
    
    public static ArrayList<String> getSubSequence(String str) {
        if(str.length()==0){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        int n=str.length();
        ArrayList<String> arrayList = getSubSequence(str.substring(1,n)); // or str.substring(1));
        int len = arrayList.size();
        for(int i=0;i<len;++i){
            arrayList.add(str.charAt(0)+arrayList.get(i));
        }
        return arrayList;
    }

    static String[] codes = {".;","abc","def","ghi","jkl",
        "mno","pqrs","tu","vwx","yz"};
    public static ArrayList <String> getKPC(String str, int idx){
        if(idx == str.length()){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(idx);
        int cidx = (int)(ch-'0');
        ArrayList <String> al = getKPC(str,idx+1);
        ArrayList <String> nal = new ArrayList<>();
        for(int i=0;i<codes[cidx].length();++i){
            char curr = codes[cidx].charAt(i);
            for(int j=0;j<al.size();++j){
                nal.add(curr+al.get(j));
            }
        }
        return nal;
    } 


    public static void main(String[] args){
        // printDecreasing(5);
        // fun(5); //find output for this by dry run !
        System.out.println(getKPC("78",0));
    }
}