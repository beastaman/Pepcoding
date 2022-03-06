import java.util.Scanner;
import java.util.ArrayList;

public class l002{
    private static Scanner scn = new Scanner(System.in);
    // Print SubSequences (Wayup)
    // Using String //printSS(str,"",0);
    public static void printSS(String str, String ans, int idx) {
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }
        printSS(str,ans+str.charAt(idx),idx+1);
        printSS(str,ans,idx+1);
    }
    //Using StringBuilder
    // StringBuilder sb = new StringBuilder();// printSS_02(str,sb,0);
    public static void printSS_02(String str, StringBuilder ans, int idx) {
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }
        ans.append(str.charAt(idx));
        printSS_02(str,ans,idx+1);
        ans.deleteCharAt(ans.length()-1);
        printSS_02(str,ans,idx+1);
    }

    // Get SubSequences (Return Type)
    public static ArrayList<String> getSubSequence(String str,int idx){
        if(idx==str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> recAns = getSubSequence(str,idx+1);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        char ch = str.charAt(idx);
        for(String s : recAns){
            myAns.add(ch + s);
        }
        return myAns;
    }

    // https://www.hackerrank.com/contests/pepdec62017/challenges/pep-java-7recursion-38asciisubsequences
    public static long countOfAsciiSubsequences(String str,int idx){
        if(idx==str.length()) return 1;
        return 3 * countOfAsciiSubsequences(str,idx+1);
    }
    public static ArrayList<String> getAsciiSubsequences(String str,int idx){
        if(idx==str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> al = getAsciiSubsequences(str,idx+1);
        char ch = str.charAt(idx);
        int val=(ch-'a')+97;
        String temp =Integer.toString(val);
        int len = al.size();
        for(int i=0;i<len;++i){
            al.add(ch+al.get(i));
        }
        for(int i=0;i<len;++i){
            al.add(temp+al.get(i));
        }
        return al;
    }

    


    public static void main(String[] args){
        String str = "abc";
        
        
    }
}