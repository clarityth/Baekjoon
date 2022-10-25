#include <stdio.h>
int arr[50], res[50], n;
void lotto(int start, int depth){
  if (depth == 6){
    for(int i=0; i<6; i++){
      printf("%d ", res[i]);
    }
    printf("\n");
    return;
  }
  for(int i=start; i<n; i++){
    res[depth] = arr[i];
    lotto(i+1, depth+1);
  }  
  return;
}

int main(void){
  while(1){
    scanf("%d", &n);
    if (n == 0)
      break;
    for(int i=0; i<n; i++){
      scanf("%d", arr+i);
    }
    lotto(0, 0);
    printf("\n");
  }
  return 0;
}