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

int main(){
    cout<<eulerFunction(5);
    return 0;
}