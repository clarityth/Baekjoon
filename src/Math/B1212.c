#include <stdio.h>
#include <string.h>
int main() {
    char hex[333335];
    scanf("%s", hex);
    int len = strlen(hex);
    if (hex[0] == '0') { printf("0"); return 0; }
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        if (hex[i] == '1') {printf("%d",1);}
        else if (hex[i] == '2') {printf("%d%d",1,0);}
        else if (hex[i] == '3') {printf("%d%d",1,1);}
        else if (hex[i] == '4') {printf("%d%d%d",1,0,0);}
        else if (hex[i] == '5') {printf("%d%d%d",1,0,1);}
        else if (hex[i] == '6') {printf("%d%d%d",1,1,0);}
        else if (hex[i] == '7') {printf("%d%d%d",1,1,1);}
        }
      else {
          if (hex[i] == '0') {printf("%d%d%d",0,0,0);}
          else if (hex[i] == '1') {printf("%d%d%d",0,0,1);}
          else if (hex[i] == '2') {printf("%d%d%d",0,1,0);}
          else if (hex[i] == '3') {printf("%d%d%d",0,1,1);}
          else if (hex[i] == '4') {printf("%d%d%d",1,0,0);}
          else if (hex[i] == '5') {printf("%d%d%d",1,0,1);}
          else if (hex[i] == '6') {printf("%d%d%d",1,1,0);}
          else if (hex[i] == '7') {printf("%d%d%d",1,1,1);}
        }
    }
    return 0;
}