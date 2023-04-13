#include <stdio.h>
#define min(a,b)(((a) < (b)) ? (a) : (b))
int dp[1000000];

int make_one(int n){
  for(int i=2; i<=n; i++){
    dp[i] = dp[i-1]+1;
    if (i%2 == 0)
      dp[i] = min(dp[i], dp[i/2]+1);
    if (i%3 == 0)
      dp[i] = min(dp[i], dp[i/3]+1);
  }
  return dp[n];
}
int main(void){
  int n, cnt=0;
  scanf("%d", &n);
  printf("%d", make_one(n));
  return 0;
}