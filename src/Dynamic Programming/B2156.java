// 포도주 시식
import java.io.*;
import java.util.*;

public class B2156 {
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    // n이 1일 경우 dp[2] 때문에 문제가 발생 -> 초기 배열 크기를 크게 지정
    int wine[] = new int[10001];
    int dp[] = new int[10001];
    for (int i = 1; i <= n; ++i) {
      wine[i] = Integer.parseInt(br.readLine());
    }
    dp[0] = 0;
    dp[1] = wine[1];
    dp[2] = wine[1] + wine[2];
    for (int i = 3; i <= n; ++i) {
      // case 1) ~xoo
      // case 2) ~oxo
      // case 3) ~oox
      dp[i] = Math.max(Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]) , dp[i - 1]);
    }
    bw.flush();
    bw.write(String.valueOf(dp[n]));
    bw.close();
    br.close();
  }
}