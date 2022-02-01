#include<bits/stdc++.h>
using namespace std;

void printHello(){
    cout<<"Hi There"<<endl;
}
void workWithDataType(){
    int a=10;
    int b=20;
    cout<<"C++ +\n";
    cout<<"Value of A: " + to_string(a) <<endl;
    cout<<"Value of B: " + to_string(b) <<endl;
}
void takeInput(){
    int n; cin>>n;
    cout<<"your number "+to_string(n)<<"\n";
}
int main(){
    // printHello();
    // workWithDataType();
    takeInput();
    return 0;
}