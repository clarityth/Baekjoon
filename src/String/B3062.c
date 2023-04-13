#include <stdio.h>

int main(void){
  int t;
  scanf("%d", &t);
  for(int i=0; i<t; i++){
    int input, cnt=0, num[6]={0,}, idx=5;
    scanf("%d", &input);
    int origin = input;
    // 입력 자릿수 분할
    while (input != 0){
      num[idx--] = input % 10;
      input /= 10;
      cnt++;
    }
    // 수 뒤집기
    int rev = 0;
    for(int j=idx+cnt; j>=idx+1; j--){
      rev = rev * 10 + num[j];
    }
    // 합 자릿수 분할
    int total = rev+origin;
    cnt=0, idx=5;
    while (total != 0){
      num[idx--] = total % 10;
      total /= 10;
      cnt++;
    }
    // 팰린드롬 체크
    int l = idx+1, r = idx+cnt, flag = 1;
    while (l < r){
      if (num[l] != num[r]){
        flag = 0;
      }
      l++; r--;
    }
    if (flag == 1)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}