#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 25

char* reverse_word(char* str);
int main(void) {
  int n;
  scanf("%d ", &n);
  for(int i=0; i<n; i++){
    char s[MAX];
    scanf(" %[^\n]", s);
    char *p = reverse_word(s);
    printf("Case #%d: %s\n", i+1, p);
  }
  return 0;
}

char* reverse_word(char* str){
  char temp[MAX];
  char *s[MAX];
  strcpy(temp, str);
  memset(str, '\0', MAX);
  
  char *ptr = strtok(temp, " ");
  int i=0, cnt=0;
  while (ptr){
    s[i++] = ptr;
    ptr = strtok(NULL, " ");
    ++cnt;
  }
  
  for(int j=cnt-1; j>=0; j--){
    strcat(str, s[j]);
    if (j > 0){
      strcat(str, " ");
    }
  }
  return str;
}