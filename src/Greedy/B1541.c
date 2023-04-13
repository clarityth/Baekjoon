#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void){
  char str[51];
  scanf("%s", str);
  int len = strlen(str), minus[25] = {0,}, num = 0, sum = 0, idx = 0;
  for (int i=0; i<=len; i++){
    if (isdigit(str[i])){
      num *= 10;
      num += str[i]-'0';
    }
    else {
      sum += num;
      if (str[i] == '-' || i == len){
        minus[idx++] = sum;
        sum = 0;
      }
      num = 0;
    }
  }
  int res = minus[0];
  for (int i = 1; i < idx; i++){
    res -= minus[i];
  }
  printf("%d", res);
  return 0;
}