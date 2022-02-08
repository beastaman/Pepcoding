#include<iostream>
using namespace std;

void test1(){
    string str = "abcdsdfv";
    str+='g';
    str.push_back('o');
    string str1 = str;  // O(n) operation 
    str1+='p'; 
    char ch =str[3];
    cout<<str<<"\n"<<str1<<"\n";
}

void test2(){
    //O(n) is time complexity for test2 
    string str = "";
    for(int i=0 ;i <(int)1e6 ;i++){
        str += to_string(i); // needed in java , O(d) d
    }
    cout<<str<<"\n";
}

int main(){
    test2();
    return 0;
}