// 오르막 수
import java.io.*;
import java.util.*;

public class B11057 {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    // dp배열에 dp[자리수][마지막 자리에 오는 수]의 형태로 저장
    long dp[][] = new long[1001][10];
    for (int i = 0; i <= 9; ++i) {
      dp[1][i] = 1;
    }
    for (int i = 1; i <= N; ++i) {
      dp[i][0] = 1;
    }
    for (int i = 2; i <= N; ++i) {
      for (int j = 1; j <= 9; ++j) {
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007l;
      }
    }
    long res = 0l;
    for (int i = 0; i < 10; ++i) {
      res += dp[N][i];
    }
    bw.flush();
    bw.write(String.valueOf(res % 10007l));
    bw.close();
    br.close();
  }
}