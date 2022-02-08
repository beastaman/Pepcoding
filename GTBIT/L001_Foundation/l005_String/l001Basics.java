import java.util.Scanner;
import java.util.Arrays;

public class l001Basics{
    private static Scanner scn = new Scanner(System.in);

    public static void test1(){
        String str = "wbjfbhjfbrwj"; // O(n)
        String str1 = str; // O(1)
        str += 'g'; // O(n)
        char ch = str.charAt(3);
    }

    public static void test2(){
        String str = "";
        for(int i=0 ;i <(int)1e6 ;i++){
            str += i;
        }
        System.out.println(str);
    }

    public static void test3(){
        StringBuilder sb = new StringBuilder(); // Similar to string C++
        sb.append('a'); // O(1)
        StringBuilder sb1 = sb; // O(1) ,same address point kar dega , changes me dikkat aa sakti hai , dono same address to point krenge
        StringBuilder sb2 = new StringBuilder(sb); // O(n) , dono diff address ko point krenge
        char ch = sb.charAt(0); 
        // sb.toString() is O(n)
        System.out.println(sb.toString());
    }

    // aabbcdd -> a2b2cd2
    public static String compress(String str){
        StringBuilder sb = new StringBuilder();
        char prevChar = '0';
        int i = 0;
        while(i<str.length()){
            int count = 1;
            while(i<str.length() && prevChar == str.charAt(i)){
                ++count;
                ++i;
            }
            sb.append(prevChar);
            sb.append(count);
            if(i<str.length()) prevChar = str.charAt(i);
            ++i;
        }
        System.out.println(sb.toString());
        return sb.toString().substring(2);
    }

    public static void main(String[] args){
        // test3();
        String res = compress("aaabbbbbddrreff");
        System.out.println(res);
    }
}