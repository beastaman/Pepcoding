#include<bits/stdc++.h>
using namespace std;

void test1(){
    int* arr = new int[10];
    // size is 10 but can be traversed for 20 , this is a disadvantage
    for(int i=0;i<20;++i) cout<<arr[i]<<" ";
}
void test2(){
    int n; cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;++i){
        cin>>arr[i];
    }
    cout<<"----------------\n";
    for(int i=0;i<n;++i){
        cout<<arr[i]<<" ";
    }
}
// if not use & then , so that copy constructor is not called
int maximumElement(vector<int>& arr){
    int maxEle =-1e8;
    for(int i=0;i<arr.size();++i){
        if(arr[i]>maxEle) maxEle=arr[i];
    }
    return maxEle;
}

int minimumElement(vector<int>& arr){
    int minEle =1e8;
    for(int i=0;i<arr.size();++i){
        if(arr[i]<minEle) minEle=arr[i];
    }
    return minEle;
}

int findElement(vector<int>& arr, int data){
    int idx =-1;
    for(int i=0;i<arr.size();++i){
        if(arr[i]==data) idx=i;
    }
    return idx;
}

int firstIndex(vector<int>& arr, int data){
    int idx =-1;
    for(int i=0;i<arr.size();++i){
        if(arr[i]==data){
            idx=i;
            break;
        }
    }
    return idx;
}

int lastIndex(vector<int>& arr, int data){
    int idx =-1;
    for(int i=arr.size()-1;i>=0;--i){
        if(arr[i]==data){
            idx=i;
            break;
        }
    }
    return idx;
}

//Sum of two arrays
void sumOfTwoArrays(vector<int>& arr1,vector<int>& arr2){
    int p=arr1.size();
    int q=arr2.size();
    int r=max(p,q)+1;
    vector<int> ans(r,0);
    int i=p-1,j=q-1,k=r-1,carry=0;
    while(k>=0){
        int sum = carry;
        if(i>=0) sum+=arr1[i--];
        if(j>=0) sum+=arr2[j--];
        ans[k--]=sum%10;
        carry=sum/10;
    }
    for(int l=0;l<ans.size();++l){
        if(l==0 && ans[l]==0) continue;
        cout<<ans[i]<<" ";
    }
}

int main(){
    // test1();
    // test2();
    int n; cin>>n;
    vector<int> arr(n);
    // for(int i=0;i<n;++i) cin>>arr[i];
    // cout<<maximumElement(arr)<<"\n";
    // cout<<minimumElement(arr)<<"\n";
    // cout<<lastIndex(arr,12)<<"\n";
    return 0;
}