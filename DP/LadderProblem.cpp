#include <iostream>
using namespace std;

int ways(int n){
    if(n == 0)
        return 1;
    if(n<0)
        return 0;
    return ways(n-1)+ways(n-2)+ways(n-3);
}

int ways2(int n,int k){
    if(n == 0)
        return 1;
    if(n< 0)
        return 0;
    int ans = 0;
    for(int i =1;i<=k;i++){
        ans += ways2(n-i,k);
    }
    return ans;
}

int waysBU(int n,int k){
    int *dp = new int[n];
    dp[0] = 1;

    for(int step = 1;step<=n;step++){
        dp[step] = 0;
        for(int i =1;i<=k;i++){
            if(step-i>=0)
                dp[step] += dp[step -i];
        }
    }
    return dp[n];
}

int main() {
    cout<<ways(4)<<endl;
    cout<<ways2(4,3)<<endl;
    cout<<waysBU(5,3)<<endl;

    return 0;
}
