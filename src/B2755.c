#include <stdio.h>
#include <math.h>

int main(void){
  int n, credit, total_credit = 0;
  double gpa = 0.0, grade_score = 0.0;
  char subject[100] = {}, grade[3] = {};
  scanf("%d", &n);
  for(int i=0; i<n; i++){
    scanf("%s %d %s", subject, &credit, grade);
    total_credit += credit;
    if (grade[0] == 'A')
      grade_score = 4.0;
    else if (grade[0] == 'B')
      grade_score = 3.0;
    else if (grade[0] == 'C')
      grade_score = 2.0;
    else if (grade[0] == 'D')
      grade_score = 1.0;
    else if (grade[0] == 'F')
      grade_score = 0.0;
    if (grade[1] == '+')
      grade_score += 0.3;
    else if (grade[1] == '-')
      grade_score -= 0.3;
    gpa += grade_score * credit;
  }
  // 부동소수점 오차
  printf("%.2lf", gpa/total_credit + 0.000000001);
  return 0;
}