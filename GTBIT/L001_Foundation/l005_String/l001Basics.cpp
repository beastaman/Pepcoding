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
// aabbcdd -> a2b2cd2
void stringCompression1(string s){
    string res;
    int freq=0;
    for(int i=0;i<(int)s.size();++i){
        if(i>0 && s[i]==s[i-1]){
            ++freq;
        }
        else if(i>0){
            res+=to_string(freq);
            freq=1;
            res+=s[i];
        }
        else{
            res+=s[i];
            freq=1;
        }
    }
    if(freq) res+=to_string(freq);
    cout<<res<<"\n";
}

int main(){
    // test2();
    stringCompression1("aaabbcccdegg");
    return 0;
}