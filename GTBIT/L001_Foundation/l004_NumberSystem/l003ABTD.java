import java.util.Scanner;
public class l003ABTD{
    private static Scanner scn = new Scanner(System.in);

    //  Any Base b to Decimal
    public static long anyBaseToDecimal(int n, int b){
        long res=0, pow =1;
        while(n > 0){
            int rem = n%10;
            res += pow*rem;
            pow *= b;
            n /= 10;
        }
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args){
        int n=scn.nextInt();
        int b=scn.nextInt();
        decimalToBinary(n); //sout(dtob(n));
        decimalToAnyBase(n,b);
    }
}