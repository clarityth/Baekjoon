#include <stdio.h>
#include <string.h>
int arr[20] = {0,};
void add(int x){
  if(arr[x] == 1)
    return;
  else
    arr[x] = 1;
}
void rem(int x){
  if(arr[x] == 1)
    arr[x] = 0;
  else
    return;
}
void check(int x){
  if (arr[x] == 1) 
    printf("1\n");
  else
    printf("0\n");
}
void toggle(int x){
  if (arr[x] == 1)
    rem(x);
  else
    add(x);
}
void all(){
  for(int i=1; i<=20; i++){
    arr[i] = 1;
  }
}
void empty(){
  for(int i=1; i<=20; i++){
    arr[i] = 0;
  }
}
int main(void){
  int n, x;
  scanf("%d", &n);
  char s[10];
  for(int i=0; i<n; i++){
    scanf("%s %d", s, &x);
    if (!strcmp(s, "add"))
      add(x);
    else if(!strcmp(s, "remove"))
      rem(x);
    else if(!strcmp(s, "check"))
      check(x);
    else if(!strcmp(s, "toggle"))
      toggle(x);
    else if(!strcmp(s, "all"))
      all();
    else if(!strcmp(s, "empty"))
      empty();
  }
  return 0;
}
