#include<iostream>
#include<vector>

using namespace std;

// find output for n = 5, dry run !
int eulerFunction(int n){
    if(n<=1){
        cout<<"Base Case: "+to_string(n)<<"\n";
        return n;
    }
    int count=0;
    cout<<"pre: "+to_string(n)<<"\n";
    count += eulerFunction(n-1);
    cout<<"in: "+to_string(n)<<"\n";
    count += eulerFunction(n-2);
    cout<<"post: "+to_string(n)<<"\n";
    return count + 3;
}

void printAToB(int a,int b){
    System.out.println(a);
    if(a==b)  return;
    printAToB(a+1,b);
}

// call with idx = 0 
void displayArrayWithRecursion(vector<int>& arr,int idx){
    if(idx == arr.size()) return;
    cout<<arr[idx]<<"\n"; // print from idx 0 to n-1
    displayArrayWithRecursion(arr,idx+1);
    cout<<arr[idx]<<"\n"; // print from idx n-1 to 0
}

int maxOfArray(vector<int>& arr,int idx){
    if(idx == arr.size()) return -1e9;
    int maxOfSmallSeg = maxOfArray(arr,idx+1);
    return max(arr[idx],maxOfSmallSeg);
}

int minOfArray(vector<int>& arr,int idx){
    if(idx == arr.size()) return 1e9;
    int minOfSmallSeg = minOfArray(arr,idx+1);
    return min(arr[idx],minOfSmallSeg);
}

bool findData(vector<int>& arr, int idx, int data){
    if(idx == arr.size()) return false;
    if(arr[idx] == data) return true;
    return findData(arr,idx+1,data);
}

int main(){
    cout<<eulerFunction(5);
    return 0;
}