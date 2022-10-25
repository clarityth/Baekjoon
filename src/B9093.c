#include <stdio.h>
#include <string.h>

int main(void){
  char arr[1001], stack[1001];
  int n, top = 0;
  scanf("%d ", &n);
  for(int i=0; i<n; i++){
    fgets(arr, 1001, stdin);
    for(int j=0; j<strlen(arr)-1; j++){
      if(arr[j] != ' '){
        stack[top++] = arr[j];
      }
      if (arr[j] == ' ' || j == strlen(arr)-2){
        for(int k=top-1; k>=0; k--){
          printf("%c", stack[k]);
        }
        printf(" ");
        top = 0;
      }
    }
    printf("\n");
  }
  return 0;
}