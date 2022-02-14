#include<iostream>
using namespace std;
#define ll long long

ll anyBaseAddition(ll n1, ll n2, ll b){
    if(n1==0 || n2==0) return max(n1,n2);
    ll carry=0, pwr=1, res=0;
    while(n1>0 || n2>0 || carry>0){
        carry+=(n1%10)+(n2%10);
        n1/=10; n2/=10;
        res+=pwr*(carry%b);
        carry/=b;
        pwr*=10;
    }
    return res;
}

ll multiplyNumberWithDigit(ll n,int d,int b,int power){
    ll res=0,carry=0;
    while(n!=0 || carry>0){
        ll sum= (n%10)*d + carry;
        ll lastdigit = sum%b; //b
        carry = sum/b; //b
        res+= lastdigit*power;
        power*=10;
        n/=10;
    }
    return res;
}

ll multiplyTwoNumbers(ll n, ll m, ll b){
    ll power=1;
    ll res=0;
    while(m!=0){
        ll lastdigit = m%10;
        ll currans = multiplyNumberWithDigit(n,lastdigit,b,power);
        res = anyBaseAddition(res,currans,b);
        power*=10;
        m/=10;
    }
    return res;
}

int main(){
    int n,m,b;
    cin>>n>>m>>b;
    cout<<multiplyTwoNumbers(n,m,b)<<"\n";
    return 0;
}