// 연산자 끼워넣기
#include <stdio.h>
int operands[11], operators[4];
int n, min = 1000000001, max = -1000000001;
void calculate(int result, int idx){
    if (idx == n){
        if(result > max)
            max = result;
        if(result < min)
            min = result;
        return;
    }
    for(int i = 0; i < 4; i++){
        if(operators[i] > 0){
            operators[i]--; // 연산자 하나 사용
            if(i == 0)
                calculate(result + operands[idx], idx+1);
            else if(i == 1)
                calculate(result - operands[idx], idx+1);
            else if(i == 2)
                calculate(result * operands[idx], idx+1);
            else
                calculate(result / operands[idx], idx+1);
            operators[i]++; // 다른 연산자를 사용
        }
    }
    return;
}
int main(void){
  scanf("%d", &n);
  for (int i=0; i<n; i++)
    scanf("%d", &operands[i]);
  for (int i=0; i<4; i++)
    scanf("%d", &operators[i]);
  calculate(operands[0], 1);
  printf("%d\n%d", max, min);
}