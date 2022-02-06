import java.util.Scanner;
public class l002DTAB{
    private static Scanner scn = new Scanner(System.in);

    // Decimal to Any Base b
    public static long decimalToAnyBase(int n, int b){
        long res=0, pow =1;
        while(n > 0){
            int rem = n%b;
            res += pow*rem;
            pow *= 10;
            n /= b;
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