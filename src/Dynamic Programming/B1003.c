#include <stdio.h>
int a[40][2] = {0,};
void fibonacci(int n) {
  a[0][0]=1; a[0][1]=0;
  a[1][0]=0; a[1][1]=1;
  for(int i=2; i<=n; i++){
    a[i][0] = a[i-2][0] + a[i-1][0];
    a[i][1] = a[i-2][1] + a[i-1][1];
  }
  return;
}

int main(void){
  int n, t;
  scanf("%d", &t);
  for (int i=0; i<t; i++){
    scanf("%d", &n);
    fibonacci(n);
    printf("%d %d\n", a[n][0], a[n][1]);
  }
}
  