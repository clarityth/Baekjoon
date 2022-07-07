#include <stdio.h>
int main(void){
  int N, M, i, j, num, sum[100001]={0, };
  scanf("%d %d", &N, &M);
  for(int k=1; k<=N; k++){
    scanf("%d", &num);
    sum[k] = sum[k-1] + num;
  }
  for(int k=0; k<M; k++){
    scanf("%d %d", &i, &j);
    printf("%d\n", sum[j]-sum[i-1]);
  }
}