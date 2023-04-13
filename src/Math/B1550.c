#include <stdio.h>
#include <string.h>
#include <math.h>

void hex_to_decimal(char* s){
  unsigned int res = 0, n=strlen(s);
  for(int i=0; i<n; i++){
    char c = s[i];
    // 0~9
    if (c >= '0' && c <= '9')
      res += pow(16,n-1-i)*(c-'0');
    // A~F (10~15)
    else if (c >= 'A' && c <= 'F')
      res += pow(16,n-1-i)*(c-'A'+10);
    // a~f (10~15)
    else if (c >= 'a' && c <= 'f')
      res += pow(16,n-1-i)*(c-'a'+10);
  }
  printf("%d", res);
}

int main(void){
  char c[7] = {};
  scanf("%s", c);
  hex_to_decimal(c);
  return 0;
}