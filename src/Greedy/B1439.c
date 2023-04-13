#include <stdio.h>
#include <string.h>
int main(void){
  char s[1000001];
  int z=0, o=0, min;
  scanf("%s", s);
  if (s[0] == '0') 
    z++; 
  else 
    o++;
  int i, l = strlen(s);
  for(i=1; i<l; i++){
    if (s[i] != s[i-1]){
      if (s[i] == '0')
        z++;
      else
        o++;
    }
  }
  if (o > z)
    min = z;
  else
    min = o;
  printf("%d", min);
  return 0;
}