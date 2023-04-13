#include <stdio.h>
#include <string.h>

int main(void){
  int n;
  scanf("%d", &n);
  char s[51][51];
  char res[51] = {'\0', };
  for(int i=0; i<n; i++){
    scanf("%s", s[i]);
  }
  if (n == 1){
    printf("%s", s[0]);
    return 0;
  }
  int flag;
  for(int i=0; i<strlen(s[0]); i++){
    flag = 1;
    for(int j=0; j<n; j++){
      if (s[j][i] != s[0][i])
        flag = 0;
    }
    if (flag == 0){
      res[i] = '?';
    }
    else {
      res[i] = s[0][i];
    }
  }
  printf("%s", res);
  return 0;  
}