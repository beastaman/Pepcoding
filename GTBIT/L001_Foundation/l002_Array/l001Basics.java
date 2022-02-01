import java.util.Scanner;
import java.util.Arrays;

public class l001Basics{
    public static Scanner scn = new Scanner(System.in);
    
    public static void test1(){
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;++i){
            arr[i]=scn.nextInt();
        }
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" Java ");
    }

    public static void test2(){
        int[] arr = new int[10];
        Arrays.fill(arr,8);
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+" ");
        }
    }
    public static int maximumElement(int[] arr){
        int maxEle =(int)-1e8;
        for(int i=0;i<arr.length;++i){
            if(arr[i]>maxEle) maxEle=arr[i];
        }
        return maxEle;
    }

    public static int minimumElement(int[] arr){
        int minEle =(int)1e8;
        for(int i=0;i<arr.length;++i){
            if(arr[i]<minEle) minEle=arr[i];
        }
        return minEle;
    }

    public static int spanOfArray(int[] arr){
        int minEle =(int)1e8;
        int maxEle =-(int)1e8;
        for(int i=0;i<arr.length;++i){
            if(arr[i]<minEle) minEle=arr[i];
            if(arr[i]>maxEle) maxEle=arr[i];
        }
        return maxEle-minEle;
    }

    public static int findElement(int[] arr, int data){
        int idx =-1;
        for(int i=0;i<arr.length;++i){
            if(arr[i]==data) idx=i;
        }
        return idx;
    }

    public static int firstIndex(int[] arr, int data){
        int idx =-1;
        for(int i=0;i<arr.length;++i){
            if(arr[i]==data){
                idx=i;
                break;
            }
        }
        return idx;
    }

    public static int lastIndex(int[] arr, int data){
        int idx =-1;
        for(int i=arr.length-1;i>=0;--i){
            if(arr[i]==data){
                idx=i;
                break;
            }
        }
        return idx;
    }
    // Sum of 2 Arrays
    public static void sumOfTwoArrays(int[] arr1,int[] arr2){
        int p=arr1.length;
        int q=arr2.length;
        int r=max(p,q)+1;
        int[] ans = new int[r];
        int i=p-1,j=q-1,k=r-1,carry=0;
        while(k>=0){
            int sum = carry;
            if(i>=0) sum+=arr1[i--];
            if(j>=0) sum+=arr2[j--];
            ans[k--]=sum%10;
            carry=sum/10;
        }
        for(int l=0;l<ans.length;++l){
            if(l==0 && ans[l]==0) continue;
            System.out.println(ans[i]);
        }
    }

    public static void main(String[] args){
        int n=scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i) arr[i]=scn.nextInt();
        System.out.println(lastIndex(arr,5));
    }
}