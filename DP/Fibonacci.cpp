#include <iostream>
using namespace std;

int fibRec(int n){
    if(n==0 || n== 1)
        return n;
    return fibRec(n-1)+ fibRec(n-2);
}

int fibTD(int n,int *dp){
    if(n == 0|| n ==1){
        dp[n] = n;
        return n;
    }
    if(dp[n] != -1)
        return dp[n];
    else{
        dp[n] = fibTD(n-1,dp)+fibTD(n-2,dp);
        return dp[n];
    }
}

int fibBU(int n){
    int *dp = new int[n];
    dp[0] = 0;
    dp[1] = 1;
    for(int i= 2;i<= n;i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
}

int fibOpt(int n){
    int a =0,b = 1;
    int c ;
    for(int i=2;i<=n;i++){
        c = a+b;
        a = b;
        b =c;
    }
    return c;
}
int main() {
    cout<<fibRec(6)<<endl;

    // DP Approaches
    int a[10];
    for(int i=0;i<10;i++)
        a[i] = -1;
    // Approach 1 ==> Topdown
    cout<<fibTD(6,a)<<endl;

    // Approach 2 ==> BottomUp
    cout<<fibBU(6)<<endl;
    
    // BottomUP Optimization
    cout<<fibOpt(6)<<endl;
    return 0;
}

