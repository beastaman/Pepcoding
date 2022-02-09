import java.util.Scanner;
public class l005AB{
    private static Scanner scn = new Scanner(System.in);

    //  Any Base Addition
    public static int anyBaseAddition(int b, int n1, int n2){
        int carry=0, pwr=1, res=0;
        while(n1>0 || n2>0 || carry>0){
            carry+=(n1%10)+(n2%10);
            n1/=10; n2/=10;
            res+=pwr*(carry%b);
            carry/=b;
            pwr*=10;
        }
        return res;
    }

    //  Any Base Subtraction return n2-n1 
    public static int anyBaseSubtraction(int b, int n1, int n2){
        int borrow=0, pwr=1, res=0;
        while(n1>0 || n2>0){
            int dif=-(n1%10)+(n2%10)+borrow;
            n1/=10; n2/=10;
            if(dif<0) {
                dif+=b;
                borrow=-1;
            }
            else{
                borrow=0;
            }
            res+=pwr*dif;
            pwr*=10;
        }
        return res;
    }
    
    public static void main(String[] args){
        int n=scn.nextInt();
        int b=scn.nextInt();
        decimalToBinary(n); //sout(dtob(n));
        decimalToAnyBase(n,b);
    }
}