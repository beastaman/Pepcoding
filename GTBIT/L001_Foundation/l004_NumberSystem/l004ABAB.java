import java.util.Scanner;
public class l003ABTD{
    private static Scanner scn = new Scanner(System.in);

    //  Any Base b1 to Any Base b2
    public static long anyBaseToAnyBase(int n, int b1,int b2){
        int res=0, pow =1;
        while(n > 0){
            int rem = n%10;
            res += pow*rem;
            pow *= b1;
            n /= 10;
        }
        n=res; res=0; pow=1;
        while(n > 0){
            int rem = n%b2;
            res += pow*rem;
            pow *= 10;
            n /= b2;
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