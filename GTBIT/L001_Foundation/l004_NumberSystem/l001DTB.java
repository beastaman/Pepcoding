import java.util.Scanner;
public class l001DTB{
    private static Scanner scn = new Scanner(System.in);
    
    //Decimal to Binary
    public static long decimalToBinary(int n){
        long res=0, pow =1;
        while(n > 0){
            int rem = n%2;
            res += pow*rem;
            pow *= 10;
            n /= 2;
        }
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args){
        int n=scn.nextInt();
        decimalToBinary(n); //sout(dtob(n));
    }
}