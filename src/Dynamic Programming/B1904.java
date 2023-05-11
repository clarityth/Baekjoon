// 01타일
import java.io.*;
import java.util.*;

public class B1904 {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    long[] dp = new long[1000001];
    dp[1] = 1l;
    dp[2] = 2l;
    // dp[1] = 1 (1)
    // dp[2] = 2 (00 11)
    // dp[3] = 3 (100 001 111)
    // dp[4] = 5 (0000 1001 1100 0011 1111)
    for (int i = 3;  i <= N; ++i) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 15746l;
    }
    bw.flush();
    bw.write(String.valueOf(dp[N] % 15746l));
    bw.close();
    br.close();
  }
}