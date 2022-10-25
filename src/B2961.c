#include <stdio.h>
#include <stdlib.h>
#define min(a,b)(((a) < (b)) ? (a) : (b))

int main(void){
  int n, minimum=1000000000;
  scanf("%d", &n);
  int a[n][2];
  for(int i=0; i<n; i++){
    scanf("%d %d", &a[i][0], &a[i][1]);
    if (minimum > abs(a[i][0]-a[i][1]))
      minimum =  abs(a[i][0]-a[i][1]);
  }
  for(int i = 1; i < 1 << n; i++) {
			int sour = 1, bitter = 0;
			for(int j = 0; j < n; j++) {
				if((i & 1<<j) > 0) {
					sour *= a[j][0];
					bitter += a[j][1];
				}
			}
			minimum = min(minimum, abs(sour-bitter));
  }
  printf("%d", minimum);
  return 0;
}