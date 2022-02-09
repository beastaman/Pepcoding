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
        if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char prevChar = str.charAt(0);
        int i = 1;
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
        // return sb.toString().substring(2);
        return sb.toString();
    }

    //abaddaccb -> a3b2c2d2  // use frequency method
    public static String compress1(String str){

        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(int i=0;i<str.length();++i){
            freq[str.charAt(i)-'a']++;
        }
        // Run Length Encoding String
        for(int i=0;i<freq.length;++i){
            char ch = (char)('a'+i);
            if(freq[i]>0){
                sb.append(ch);
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }

    //https://nados.io/question/string-compression?zen=true
    public static String compression3(String str){
		if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char prevChar = str.charAt(0);
        int i = 1;
        while(i<str.length()){
            int count = 1;
            while(i<str.length() && prevChar == str.charAt(i)){
                ++count;
                ++i;
            }
            sb.append(prevChar);
            if(i==str.length())	break;
			prevChar = str.charAt(i);
        }
        return sb.toString();
	}

    //https://nados.io/question/string-compression?zen=true
	public static String compression4(String str){
		if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char prevChar = str.charAt(0);
        int i = 0;
        while(i<str.length()){
            int count = 1;
			++i;
            while(i<str.length() && prevChar == str.charAt(i)){
                ++count;
                ++i;
            }
            sb.append(prevChar);
            if(count>1) sb.append(count);
            if(i==str.length())	break;
			prevChar = str.charAt(i);
        }
        return sb.toString();
	}

    //Toggle Case
    public static void toggleCase(String str){
		//write your code here
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();++i){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append((char)('A'+(ch-'a')));
            }
            else{
                sb.append((char)('a'+(ch-'A')));
            }
        }
        System.out.println(sb.toString());
	}

    // Print All Palindromic Substrings
    public static void printAllPalindromicSubStrings(String str){
		//write your code here
		for(int i=0;i<str.length();++i){
			for(int j=i;j<str.length();++j){
				int si=i,ei=j;
				boolean flag=true;
				while(si<=ei){
					if(str.charAt(si)==str.charAt(ei)){
						++si;
						--ei;
					}
					else{
						flag=false;
						break;
					}
				}
				if(flag){
					System.out.println(str.substring(i,j+1));
				}
			}
		}
	}
    // String with Diff of every Consecutive character
    public static String stringWithDiffConsecutive Char(String str){
		// write your code here
        if(str.length() <=1) return str;
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for(int i=1;i<str.length();++i){
			sb.append((int)(str.charAt(i)-str.charAt(i-1)));
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

    //Print All Permutations of String Iteratively
    public static void printAllPermutationIteratively(String str){
        ArrayList<String> ans = new ArrayList<>();
        ans.add(str.charAt(0)+"");
        for(int i=1;i<str.length();++i){
            char ch = str.charAt(i);
            ArrayList<String> smallAns = new ArrayList<>();
            for(String s : ans){
                for(int j=0;j<=s.length();++j){
                    String ns = s.substring(0,j)+ch+s.substring(j);
                    smallAns.add(ns);
                }
            }
            ans = smallAns;
        }
    }

    // Factorial of a Number
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    //Print All Permutations of String Iteratively -- Sumeet Sie method
    public static void printAllPermutationIterativelyTricky(String str){
        int n = str.length();
        int f = factorial(n);
        for(int i=0;i<f;++i){
            StringBuilder sb = new StringBuilder(str);
            int temp=i;
            for(int div=n;div>=1;--div){
                int q = temp/div;
                int r = temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        // test3();
        String res = compress1("aaabbbbbddrreff");
        System.out.println(res);
    }
}