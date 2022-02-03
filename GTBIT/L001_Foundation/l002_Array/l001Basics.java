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
        int r=Math.max(p,q)+1;
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
    // Diff of Two arrays , arr2 is greater than arr1
    public static void diffOfTwoArrays(int[] arr2, int[] arr1){
        int n1=arr1.length;
        int n2=arr2.length;
        int brw=0;
        int[] ans = new int[n2];
        int p=n1-1,q=n2-1,k=n2-1;
        while(k>=0){
            int diff=brw;
            if(q>=0) diff+=arr2[q--];
            if(p>=0) diff-=arr1[p--];
            brw=0;
            if(diff<0){
                --brw;
                diff+=10;
            }
            ans[k--]=diff;
        }
        int l=0;
        while(l<n2 && ans[l]==0) ++l;
        if(l==n2) System.out.println(0);
        for(;l<n2;++l) System.out.println(ans[l]);
    }

    // Reverse an array
    public static void reverse(int[] a,int lo,int hi) {
        while(lo<=hi){
            int temp=a[lo];
            a[lo]=a[hi];
            a[hi]=temp;
            ++lo;--hi;
        }
    }

    // Rotate an array by k
    public static void rotate(int[] a, int k) {
        int n=a.length;
        k=k%n;
        if(k<0) k+=n;
        reverse(a,0,n-k-1);
        reverse(a,n-k,n-1);
        reverse(a,0,n-1);
    }

    //Inverse of an array
    public static int[] inverse(int[] arr){
        int n=arr.length;
        int[] res= new int[n];
        for(int i=0;i<n;++i){
        res[arr[i]]=i;
        }
        return res;
    }

    //print all subarrays of leetcode
    public static void printAllSubarrays(int[] arr){
        Scanner scn = new Scanner(System.in);
        int n=arr.length;
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                for(int k=i;k<=j;++k){
                    System.out.print(arr[k]+"\t");
                }
                System.out.println();
            }
        }
    }

    // binary search in sorted array
    public static void binarySearch(int[] arr,int data){
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid = (si+ei) /2;
            if(arr[mid] == data){
                return mid;
            }
            else if(data < arr[mid]){
                ei=mid-1;
            }
            else si=mid+1;
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
		int[] arr = new int[n];
        for(int i=0;i<n;++i) arr[i] = scn.nextInt();
        int k = scn.nextInt();
        rotate(arr,k);
    }
}