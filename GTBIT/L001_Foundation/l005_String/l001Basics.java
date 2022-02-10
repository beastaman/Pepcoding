import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

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
    public static String stringWithDiffConsecutiveChar(String str){
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

    //https://codingbat.com/prob/p151359
    public static String withoutX2(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();++i){
            if(i<2 && str.charAt(i)=='x') continue;
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Remove Primes
    public static ArrayList<Integer> removePrimes(ArrayList<Integer> al){
		// write your code here
		ArrayList<Integer> nal = new ArrayList<>();
		for(int x: al){
			if(isPrime(x)==false) nal.add(x);
		}
		return nal;
	}

    //https://leetcode.com/problems/reverse-string-ii/  -- StringBuilder Method
    public static String reverseStr1(String s, int k) {
        int n=s.length();
        StringBuilder sb = new StringBuilder(s);
        int si=0;
        while(si<n){
            int lo=si,hi=si+k-1;
            if(hi>=n) hi=n-1;
            while(lo<=hi){
                char chl=sb.charAt(lo);
                char chh=sb.charAt(hi);
                sb.setCharAt(lo,chh);
                sb.setCharAt(hi,chl);
                ++lo;
                --hi;
            }
            si+=2*k;
        }
        return sb.toString();
    }

    //https://leetcode.com/problems/reverse-string-ii/  -- toCharArray() Approach
    public static String reverseStr2(String s, int k) {
        char[] ca = s.toCharArray();
        int n=s.length();
        int si=0;
        while(si<n){
            int lo=si,hi=si+k-1;
            if(hi>=n) hi=n-1;
            while(lo<=hi){
                char temp = ca[lo];
                ca[lo] = ca[hi];
                ca[hi] = temp;
                ++lo;
                --hi;
            }
            si += 2*k;
        }
        s = String.valueOf(ca);
        return s;
    }

    // https://leetcode.com/problems/first-unique-character-in-a-string/
    public static int firstUniqChar(String s) {
        int n=s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;++i){
            freq[(int)(s.charAt(i)-'a')]++;
        }
        int res=-1;
        for(int i=0;i<n;++i){
            if(freq[s.charAt(i)-'a']==1){
                res=i;
                break;
            }
        }
        return res;
    }

    
    // Salesforce London Interview Ques
    public static boolean isPrime(int n){
        boolean flag=true;
        for(int i=2;i*i<=n;++i){
            if(n%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void primeNumbers(int n,ArrayList<Integer> ans){
        for(int i=2 ;i*i<=n;++i){
            if(isPrime(i)) ans.add(i);
        }
    }
    public static void primeFactorsForQuery(){
        ArrayList<Integer> list = new ArrayList<>();
        primeNumbers(500,list);
        System.out.println(list);
    }
    // Upto here
    

    public static void main(String[] args){
        primeFactorsForQuery();
    }
}