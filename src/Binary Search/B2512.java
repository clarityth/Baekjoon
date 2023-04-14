// 예산
import java.io.*;
import java.util.*;

public class B2512 {
  static int N, M, requestedBudgets[];

  static boolean check(int mid) {
    int budgetSum = 0;
    for (int i = 0; i < N; ++i) {
      if (mid > requestedBudgets[i]) {
        budgetSum += requestedBudgets[i];
      } else {
        budgetSum += mid;
      }
    }
    if (budgetSum > M)
      return false;
    else
      return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    requestedBudgets = new int[N];
    int start = 0, end = 0, requestedBudgetSum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      requestedBudgets[i] = Integer.parseInt(st.nextToken());
      if (requestedBudgets[i] > end)
        end = requestedBudgets[i];
      requestedBudgetSum += requestedBudgets[i];
    }
    
    M = Integer.parseInt(br.readLine());
    if (M >= requestedBudgetSum){
      bw.write(String.valueOf(end));
      bw.flush();
      bw.close();
      br.close();
      return;
    }
    
    while (start <= end) {
      int mid = (start + end) / 2;
      if (check(mid)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    bw.write(String.valueOf(end));
    bw.flush();
    bw.close();
    br.close();
  }
}