#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b){
    int num1 = *(int *)a;   
    int num2 = *(int *)b; 
    if (num1 < num2)   
        return -1;     
    if (num1 > num2)   
        return 1;     
    return 0;   
}

int main(void){
  int n;
  scanf("%d", &n);
  int arr[n];
  for(int i=0; i<n; i++){
    scanf("%d", arr+i);
  }
  qsort(arr, sizeof(arr)/sizeof(int), sizeof(int), compare);
  int temp=0, res=0;
  for(int i=0; i<n; i++){
    temp += arr[i];
    res += temp;
  }
  printf("%d", res);
  return 0;
}