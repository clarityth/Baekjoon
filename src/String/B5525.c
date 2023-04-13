#include <stdio.h>
#include <string.h>
int main(void){
  int n, m, num=0, cnt=0;
  scanf("%d", &n);
  scanf("%d", &m);
  char s[m];
  scanf("%s", s);
  for(int i=0; i<m-2; i++){
    if(s[i] == 'I' && s[i+1] == 'O' && s[i+2] == 'I'){
      ++num;
      if(num == n){
        ++cnt;
        --num;
      }
      i++;
    }
    else{
      num = 0;
      continue;
    }
  }
  printf("%d", cnt);
}

// int main(void){
//   int n, m;
//   scanf("%d", &n);
//   scanf("%d", &m);
//   char s[m]; 
//   char expected[2000001]={'\0',};
//   expected[0] = 'I';
//   for(int i=1; i<=2*n; i++){
//     if(i%2 == 1)
//       expected[i] = 'O';
//     else
//       expected[i] = 'I';
//   }
//   scanf("%s", s);
//   int cnt = 0;
//   char* ptr = strstr(s, expected);
  
//   while(ptr){
//     ++cnt;
//     ptr = strstr(ptr+1, expected);
//   }
//   printf("%d", cnt);
//   return 0;
// }